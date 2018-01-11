package com.hh.spring4.x.section4_IOC;

import com.hh.spring4.x.section4_IOC_Reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESC: 注解类
 * Created by Hh on 2018/1/11
 */

@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("BMW");
        car.setColor("red");
        car.setMaxSpeed(300);
        return car;
    }
}
