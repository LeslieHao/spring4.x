package com.hh.spring4.x.section4_IOC;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * DESC: 工厂方法注入
 * Created by Hh on 2018/1/15
 */
public class CarFactory {

    /**
     * 非静态工厂方法
     * @return
     */
    public Car createBMW(){
        Car car = new Car();
        car.setBrand("BMW 740i");
        return car;
    }

    /**
     * 静态工厂方法
     * @return
     */
    public static Car createAudi(){
        Car car = new Car();
        car.setBrand("Audi A8L");
        return car;
    }



    @Test
    public void testFactory() {
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        reader.loadBeanDefinitions(res);
        Car car = (Car) beanFactory.getBean("car4");
        car.intrduce();
    }

}
