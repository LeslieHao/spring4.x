package com.hh.spring4.x.section4_IOC;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * DESC:
 * Created by Hh on 2018/1/11
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    //接口方法 实例化bean 前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("car1".equals(beanName)) {
            System.out.println("Before---postProcessBeforeInstantiation");
        }
        return null;
    }

    // 实例化bean 后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car1".equals(beanName)) {
            System.out.println("After---postProcessAfterInstantiation");
        }

        return true;
    }

    // 设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car1".equals(beanName)) {
            System.out.println("Pro---postProcessPropertyValues");
        }

        return pvs;
    }


    public static void main(String[] args) {
        double a = 100.02;
        double d = 100.02;
        double b = 200.92;

        boolean c = b - a == 100.9;

        System.out.println(b-a);
        System.out.println(c);
    }
}
