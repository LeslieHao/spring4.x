package com.hh.spring4.x.section7_AOP_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DESC: 动态代理handler 类
 * Created by Hh on 2018/1/18
 */
public class PerformanceHandler implements InvocationHandler {

    private Object object;

    public PerformanceHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerFormanceMonitor.begin(object.getClass().getName() + "." + method.getName());
        // 通过反射方法调用业务类目标方法
        Object obj = method.invoke(object, args);
        PerFormanceMonitor.end();
        return obj;
    }
}
