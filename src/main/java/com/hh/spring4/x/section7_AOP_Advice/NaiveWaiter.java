package com.hh.spring4.x.section7_AOP_Advice;

import com.hh.spring4.x.section8_AspectJ.Greeting;

/**
 * DESC:
 * Created by Hh on 2018/1/18
 */
public class NaiveWaiter implements Waiter {

    @Greeting
    @Override
    public String greetTo(String name) {
        System.out.println("greet to " + name + ".");
        return "返回啦~~~~";
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name + ".");
    }
}
