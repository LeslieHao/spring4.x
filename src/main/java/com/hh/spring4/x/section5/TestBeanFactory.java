package com.hh.spring4.x.section5;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * DESC: BeanFactory 面向Spring
 * ApplicationContext 面Spring 使用者者
 * Created by Hh on 2018/1/16
 */
@DirtiesContext //待整个测试类的所有测试执行结束后，该测试的application context会被关闭，同时缓存会清除
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestBeanFactory extends AbstractTransactionalJUnit4SpringContextTests implements BeanFactoryAware {

    @Autowired
    private UserService userService;

    private BeanFactory beanFactory;


    @Test
    public void testBeanFactory(){
        System.out.println(this.beanFactory);
    }


    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
