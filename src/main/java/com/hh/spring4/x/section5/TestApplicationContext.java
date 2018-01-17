package com.hh.spring4.x.section5;

import com.hh.spring4.x.section4_IOC.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DESC: BeanFactory 面向Spring
 * ApplicationContext 面Spring 使用者者
 * Created by Hh on 2018/1/16
 */
public class TestApplicationContext {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ((Car)context.getBean("car1")).intrduce();
    }
}
