package com.hh.spring4.x.section7_AOP_Advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * DESC: 环绕增强
 * Created by Hh on 2018/1/18
 */
public class GreetingAroundIntercept implements org.aopalliance.intercept.MethodInterceptor {

    /**
     * 截获目标方法
     *
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments(); // 目标方法入参
        String clientName = (String) args[0];
        System.out.println("Hello Mr." + clientName);
        Object obj = methodInvocation.proceed(); // 通过反射调用目标方法
        System.out.println("Over");
        return obj;
    }
}
