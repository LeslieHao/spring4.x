package com.hh.spring4.x.section5;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 注解
 */
// 等价于 <bean id="userDao" class="com.hh.spring4.x.section5.UserDao"/>
@Lazy
@Scope("prototype")
@Component("userDao")
public class UserDao {

    /*
        除了@Component 之外。 Spring 还提供了3个和其等效的注解。
        @Repository 用于对Dao 实现类的标注
        @Service 用于对Service 实现类的标注
        @Controller 用于对Controller 实现类的标注
        完全可以使用@Component 替代这3个注解，但是为了区分，推荐使用特定的注解
     */

}
