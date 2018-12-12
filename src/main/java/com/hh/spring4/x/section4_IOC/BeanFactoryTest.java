package com.hh.spring4.x.section4_IOC;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * DESC:
 * Created by Hh on 2018/1/11
 */
public class BeanFactoryTest {


    // 容器中存放的不是代理对象
    // BeanDefinition
    @Test
    public void AppCtx(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Car car = ctx.getBean("car1", Car.class);
        System.out.println(car);
    }

    @Test
    public void getBean() throws IOException {
        // 得到 beans.xml 的Resource
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beans.xml");
        System.out.println(res.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        // XmlBeanDefinitionReader 通过Resource 装载Spring 配置信息并启动IOC 容器
        reader.loadBeanDefinitions(res);
        System.out.println("init BeanFactory");

        // 通过getBean 方法从IOC 容器中获取Bean
        // 通过BeanFactory 启动IOC 容器时，并不会初始化配置文件中定义的Bean, 初始化动作发生在第一个调用时
        Car car = factory.getBean("car", Car.class);
        System.out.println("Car is ready");
        car.intrduce();

        /*
            对于单例的Bean 来说，BeanFactory 会缓存Bean 实例，
            所以第二次调用getBean 时，直接从IOC 容器的缓存中获取Bean 实例。
         */
    }
}
