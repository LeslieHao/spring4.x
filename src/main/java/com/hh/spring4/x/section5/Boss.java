package com.hh.spring4.x.section5;

import com.hh.spring4.x.section4_IOC.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.PrimitiveIterator;

/**
 * DESC:
 * Created by Hh on 2018/1/16
 */
@Component
public class Boss {

    private Car car;

    public Boss() {
        System.out.println("construct.....");
    }

    @Autowired(required = false)
    public void setCar(Car car) {
        System.out.println("setCar.....");
        this.car = car;
    }

    @PostConstruct
    private void init1(){
        System.out.println("init1.....");
    }

    @PostConstruct
    private void init2(){
        System.out.println("init2.....");
    }

    @PreDestroy
    private void destroy1(){
        System.out.println("destroy1....");
    }
    @PreDestroy
    private void destroy2(){
        System.out.println("destroy2....");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ((ClassPathXmlApplicationContext)ctx).destroy();
    }
}
