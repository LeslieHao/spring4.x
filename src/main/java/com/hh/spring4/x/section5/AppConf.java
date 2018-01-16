package com.hh.spring4.x.section5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESC:
 * Created by Hh on 2018/1/16
 */
@Configuration
public class AppConf {

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public UserService userService(){
        UserService userService = new UserService();
        userService.setUserDao(userDao());
        return userService;
    }
}
