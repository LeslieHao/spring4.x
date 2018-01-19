package com.hh.spring4.x.section8_AspectJ;

/**
 * DESC:
 * Created by Hh on 2018/1/19
 */
public @interface Greeting {

    String value() default "greeting~";
}
