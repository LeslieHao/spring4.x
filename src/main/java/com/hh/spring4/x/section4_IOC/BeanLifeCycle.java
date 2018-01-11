package com.hh.spring4.x.section4_IOC;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * DESC: 生命周期 收集
 * Created by Hh on 2018/1/11
 */
public class BeanLifeCycle {

    private static void LifeCycleInBeanFactory(){
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
        reader.loadBeanDefinitions(res);

        ConfigurableBeanFactory confBF = (ConfigurableBeanFactory) bf;
        confBF.addBeanPostProcessor(new MyBeanPostProcessor());
        confBF.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = (Car) bf.getBean("car1");
        car1.intrduce();
        car1.setColor("red");
        Car car2 = (Car) bf.getBean("car1");

        System.out.println("两次是否相等：" + (car1 == car2));

        confBF.destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
