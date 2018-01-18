package com.hh.spring4.x.section7_AOP_Advice;

import com.hh.spring4.x.section7_AOP_Proxy.ForumService;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.cert.X509Certificate;

/**
 * DESC: 增强的测试类
 * Created by Hh on 2018/1/18
 */
public class AdviceTest {

    @Test
    public void testBefore(){
//        Waiter target = new NaiveWaiter();
//        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
//
//        // spring 提供的代理工厂
//        ProxyFactory pf = new ProxyFactory();
//        // 设置代理目标
//        pf.setTarget(target);
//        // 为代理目标添加增强
//        pf.addAdvice(beforeAdvice);
//        // 生成代理实例
//        Waiter proxy = (Waiter) pf.getProxy();
//        proxy.greetTo("John");
//        proxy.serveTo("Tom");

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
    }

    @Test
    public void testAfter(){
        Waiter target = new NaiveWaiter();
        AfterReturningAdvice afterReturningAdvice = new GreetingAfterAdvice();

        // spring 提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        // 设置代理目标
        pf.setTarget(target);
        // 为代理目标添加增强
        pf.addAdvice(afterReturningAdvice);
        // 生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    @Test
    public void testAround(){

        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        System.out.println(waiter.greetTo("Micheal"));
    }


    @Test
    public void testYinJie(){
        ForumService forumService = (ForumService) ctx.getBean("forumService");

        forumService.removeForum(001);
        forumService.removeTopic(002);

        Monitorable monitorable = (Monitorable) forumService;

        monitorable.setMonitorActive(true);

        forumService.removeForum(003);
        forumService.removeTopic(004);

    }
}
