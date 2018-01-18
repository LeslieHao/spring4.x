package com.hh.spring4.x.section7_AOP_Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * DESC:CDLIB 代理
 * 采用底层字节码技术，可以为一个类创建子类，
 * 在子类中采用方法拦截的技术拦截所有父类方法的调用并顺势插入横切逻辑。
 * Created by Hh on 2018/1/18
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public java.lang.Object getProxy(Class clazz) {
        // 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /**
     * 拦截父类所有方法的调用
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerFormanceMonitor.begin(o.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        PerFormanceMonitor.end();
        return result;
    }
}
