package com.hh.spring4.x.section4_IOC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * DESC:
 * Created by Hh on 2018/1/11
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if ("car1".equals(s)) {
            Car car = (Car) o;
            if (car.getColor() == null) {
                System.out.println("BeanPostProcessor.postProcessBeforeInitialization,Color 为空");
                car.setColor("Black");
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if ("car1".equals(s)) {
            Car car = (Car) o;
            if (car.getMaxSpeed() > 200) {
                System.out.println("BeanPostProcessor.postProcessAfterInitialization,MaxSpeed>300 ");
                car.setMaxSpeed(200);

            }
        }
        return o;
    }
}
