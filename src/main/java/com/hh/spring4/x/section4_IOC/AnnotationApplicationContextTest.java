package com.hh.spring4.x.section4_IOC;
import com.hh.spring4.x.section4_IOC_Reflect.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;


/**
 * DESC: ApplicationContext
 * Created by Hh on 2018/1/11
 */
public class AnnotationApplicationContextTest {

    /**
     * AnnotationConfigApplicationContext 记载Beans.class 中的Bean 定义并调用其中的方法实例化Bean
     * 启动容器并装配Bean
     */
    @Test
    public void getBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car car = context.getBean("car", Car.class);
        assertNotNull(car);
        car.intrduce();
    }
}
