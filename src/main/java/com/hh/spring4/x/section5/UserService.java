package com.hh.spring4.x.section5;

import com.hh.spring4.x.section4_IOC.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DESC: 自动装配Bean
 * Created by Hh on 2018/1/16
 */
@Service
public class UserService {

    /**
     * @Autowired 默认按类型匹配的方式在容器中查找匹配的Bean。
     * 当有且仅有一个匹配的Bean 时，Spring 将其注入标有@Autowired 的变量
     * required 默认为true 此时如果没有类型匹配的Bean，则抛出异常
     * 设置为false 时，当匹配不到时也不会抛出异常
     */
    @Autowired(required = false)

    /**
     * 若有多个匹配的Bean 时，则可通过@Qualifier 注解限定Bean 的名称。
     */
    @Qualifier("userDao")

    /**
     *  延迟注解（调用此属性的时候才会注入）
     */
    @Lazy
    private UserDao userDao;


    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired(required = false)
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

}
