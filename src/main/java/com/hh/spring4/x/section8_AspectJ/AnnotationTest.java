package com.hh.spring4.x.section8_AspectJ;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * DESC: 注解测试类
 * Created by Hh on 2018/1/19
 */
public class AnnotationTest {

    @Test
    public void test1(){
        Class cls = ForumService.class;
        Method[] methods = cls.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method m: methods) {
            NeedTest n = m.getAnnotation(NeedTest.class);
            if (n != null) {
                if (n.value()) {
                    System.out.println(m.getName() + "需要测试");
                } else {
                    System.out.println(m.getName()+"不需要测试");
                }
                System.out.println(n.str());
            }
        }
    }
}
