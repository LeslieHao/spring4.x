package com.hh.spring4.x.section4_IOC_Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * DESC: 反射方式操作对象
 * Created by Hh on 2018/1/10
 */
public class ReflectCar {

    public static Car getCarByReflection() throws Throwable {
        // 获取当前线程的类加载器
        // 通过指定全类名 装在Car 类对应的反射实例。
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class cls = loader.loadClass("com.hh.spring4.x.section4_IOC_Reflect.Car");

        // 获取类的默认构造器对象 并通过它实例化Car  等同于new Car()
        Constructor cons = cls.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();

        // 通过反射方式设置属性
        Method setBrand = cls.getMethod("setBrand", String.class);
        setBrand.invoke(car, "Mercedes Benz");
        Method setColor = cls.getMethod("setColor", String.class);
        setColor.invoke(car, "Black");
//        Method setMaxSpeed = cls.getMethod("setMaxSpeed", int.class);
//        setMaxSpeed.invoke(car, 300);

        Field maxSpeed = cls.getDeclaredField("maxSpeed");
        maxSpeed.setAccessible(true);
        maxSpeed.set(car, 500);

        // 通过反射可以调用私有方法
        Method driver = cls.getDeclaredMethod("drive", null);
        driver.setAccessible(true); // 取消java 语言检查
        driver.invoke(car, null);
        return car;
    }


    public static Car getCarByReflection1() throws Throwable {
        Car car = new Car();
        Class cls = Car.class;
        Method setBrand = cls.getMethod("setBrand", String.class);
        setBrand.invoke(car, "Mercedes Benz");
        Method setColor = cls.getMethod("setColor", String.class);
        setColor.invoke(car, "Black");
        Method setMaxSpeed = cls.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 300);
        return car;
    }



    public static void main(String[] args) throws Throwable {
        Car car = getCarByReflection();
        car.intrduce();
    }

}
