package com.hh.spring4.x.section1;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * DESC: 4.0 新特性
 * Created by Hh on 2018/1/2
 */
@PropertySource("classpath:/config.properties")
@PropertySource("classpath:/config1.properties")
public class NewProperties {
    @Value("${name}")
    String name;

    @Value("${age}")
    int age;

    @Autowired
    Environment environment;


    @Test
    @MyAnnotation(role = "Boy")
    @MyAnnotation(role = "Girl")
    public void test1() {
        System.out.println(name + age);
        System.out.println(environment.getProperty("name"));
    }

    public static void main(String[] args) {
        new NewProperties().test1();
    }

}
