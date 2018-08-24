package com.hh.spring4.x.section15_cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hh.spring4.x.entity.UserEntity;

/**
 * @author HaoHao
 * @Description: 缓存测试类
 * @date 2018/8/24下午4:17
 */
public class CacheTest {


    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Context.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserEntity entity = new UserEntity();
        entity.setUserId("1");

        System.out.println("first query");
        UserEntity e1 = userService.getUserById("1");
        System.out.println(e1.toString());
        System.out.println("second query");
        UserEntity e2 = userService.getUserById("1");
        System.out.println(e2.toString());

    }
}
