package com.hh.spring4.x.section4_IOC;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * DESC: 构造函数注入
 * Created by Hh on 2018/1/15
 */
public class ConstructInject {

    @Test
    public void test(){
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(res);
        Car car = (Car) factory.getBean("car2");
        car.intrduce();
    }
}
