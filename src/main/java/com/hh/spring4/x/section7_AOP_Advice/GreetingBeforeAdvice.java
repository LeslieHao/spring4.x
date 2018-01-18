package com.hh.spring4.x.section7_AOP_Advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * DESC:
 * Created by Hh on 2018/1/18
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {


    /**
     * 目标类方法调用前执行
     * @param method 目标方法
     * @param objects 入参
     * @param o 目标类实例
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String) objects[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
