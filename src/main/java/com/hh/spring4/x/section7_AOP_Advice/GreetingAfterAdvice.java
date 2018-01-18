package com.hh.spring4.x.section7_AOP_Advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * DESC:
 * Created by Hh on 2018/1/18
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    /**
     *
     * @param returnObj 目标方法返回结果
     * @param method
     * @param objects
     * @param o1
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnObj, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself");
        System.out.println(returnObj);
    }
}
