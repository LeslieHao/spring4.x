package com.hh.spring4.x.section7_AOP_Proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * DESC: 调用测试类
 * Created by Hh on 2018/1/17
 */
public class ForumServiceImpl implements ForumService {



    public void removeTopic(int topicId) {

        // 开始对该方法进行性能监视
//        PerFormanceMonitor.begin("com.hh.spring4.x.section7_AOP_Proxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic 记录" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 结束监视
//        PerFormanceMonitor.end();
    }

    public void removeForum(int forumId) {
        // 开始对该方法进行性能监视
//        PerFormanceMonitor.begin("com.hh.spring4.x.section7_AOP_Proxy.removeForum.removeForum");
        System.out.println("模拟删除Forum 记录" + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 结束监视
//        PerFormanceMonitor.end();
    }

    /**
     * JDK 动态代理的方式
     * 将代码抽取到Handler 中
     * 只可面向接口
     */
    @Test
    public void proxy(){
        // 希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();

        // 将目标业务类和横切代码编织到一起
        PerformanceHandler performanceHandler = new PerformanceHandler(target);

        // 创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                performanceHandler);

        // 调用代理实例
        proxy.removeForum(001);
        proxy.removeTopic(002);
    }


    /**
     * cglib 动态代理
     */
    @Test
    public void cglibProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(001);
        forumService.removeTopic(002);
    }

    public static void main(String[] args) {
        ForumServiceImpl forumService = new ForumServiceImpl();
        forumService.removeForum(001);
    }
}
