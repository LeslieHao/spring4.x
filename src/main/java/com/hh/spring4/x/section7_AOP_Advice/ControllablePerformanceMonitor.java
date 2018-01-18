package com.hh.spring4.x.section7_AOP_Advice;

import com.hh.spring4.x.section7_AOP_Proxy.PerFormanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * DESC:
 * Created by Hh on 2018/1/18
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<>();


    @Override
    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        if (monitorStatusMap.get() != null && monitorStatusMap.get()) {
            PerFormanceMonitor.begin(mi.getClass().getName());
            obj = super.invoke(mi);
            PerFormanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
