package com.hh.spring4.x.section7;

/**
 * DESC:
 * Created by Hh on 2018/1/17
 */
public class MethodPerformance {
    private long biegin;
    private long end;
    private String serviceMethod;

    public MethodPerformance( String serviceMethod) {
        this.biegin = System.currentTimeMillis();
        this.serviceMethod = serviceMethod;
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - biegin;
        System.out.println(serviceMethod+"花费了："+elapse+"毫秒");
    }
}
