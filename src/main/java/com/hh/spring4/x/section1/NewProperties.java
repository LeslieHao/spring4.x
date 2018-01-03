package com.hh.spring4.x.section1;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * DESC: 4.0 新特性
 * Created by Hh on 2018/1/2
 */
@PropertySource("classpath:/config.properties")
@PropertySource("classpath:/config1.properties")
public class NewProperties<T> {
    @Value("${name}")
    String name;

    @Value("${age}")
    int age;

    @Autowired
    Environment environment;


    /**
     * 重复注解的支持
     */
    @Test
    @MyAnnotation(role = "Boy")
    @MyAnnotation(role = "Girl")
    public void test1() {
        System.out.println(name + age);
        System.out.println(environment.getProperty("name"));
    }

    /**
     * Optional
     */
    @Autowired
    private Optional<UserDao> userDao;

    void findUser(String name) {
        if (userDao.isPresent()) {
            // find
        }
    }
    @RequestMapping("")
    public String getName(String id, Optional<String> sex) {
        return "";
    }

    /**
     * 泛型依赖注入
     */
    @Autowired
    BaseDao<T> dao;
    /**
     * Map依赖注入
     */
    @Autowired
    Map<String,String> map;
    /**
     * List依赖注入
     */
    @Autowired
    List<String> list;



}
