package com.hh.spring4.x.section8_AspectJ;

import com.hh.spring4.x.section7_AOP_Advice.NaiveWaiter;
import com.hh.spring4.x.section7_AOP_Advice.Waiter;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DESC:
 * Created by Hh on 2018/1/19
 */
public class AspectJProxyTest {
    @Test
    public void testAspectJBefore() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);

        Waiter waiterProxy = factory.getProxy();
        waiterProxy.greetTo("尼古拉斯赵四");
//        waiterProxy.serveTo("尼古拉斯赵本山");
    }
    @Test
    public void testAspectJBefore2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Waiter waiterProxy = (Waiter) ctx.getBean("waiter3");
        waiterProxy.greetTo("尼古拉斯赵四");
        waiterProxy.serveTo("尼古拉斯赵本山");
    }

}
