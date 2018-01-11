package com.hh.spring4.x.section4_IOC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * DESC: Bean 生命周期过程
 * Created by Hh on 2018/1/11
 */
public class Car  implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{

    private String brand;

    private String color;

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    private int maxSpeed;

    private BeanFactory beanFactory;

    private String beanName;

    public Car() {
        System.out.println("调用构造函数");
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void intrduce(){
        System.out.println("This is a "+brand+"; Color:"+color+"; maxSpeed:"+maxSpeed+". It's a nice car!");
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand");
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static void main(String[] args) {
        System.out.println("1");
    }

    private void drive() {
        System.out.println("开车啦~~~~");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("调用 BeanNameAware.setBeanName");
        this.beanName = s;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet");
    }

    /**
     *
     */
    public void myInit(){
        System.out.println("调用init-method 所指定的myInit,设置属性");
        this.maxSpeed = 240;
    }

    public void myDestroy(){
        System.out.println("调用destroy-method 指定的myDestroy");
    }
}
