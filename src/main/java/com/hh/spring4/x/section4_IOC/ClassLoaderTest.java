package com.hh.spring4.x.section4_IOC;

/**
 * DESC: 类装载器
 * Created by Hh on 2018/1/10
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent()); // 根装载器在Java 中看不到
    }


}
