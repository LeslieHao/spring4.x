package com.hh.spring4.x.section7_AOP_Advice;

/**
 * DESC:
 * Created by Hh on 2018/1/18
 */
public class NaiveWaiter implements Waiter {

    @Override
    public String greetTo(String name) {
        System.out.println("greet to " + name + ".");
        return "返回值";
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name + ".");
    }
}
