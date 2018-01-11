package com.hh.spring4.x.section4_IOC_Reflect;

import org.springframework.core.io.Resource;

/**
 * DESC:
 * Created by Hh on 2018/1/10
 */
public class Car {

    private String brand;

    private String color;

    private int maxSpeed;

    public Car() {
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
}
