package com.hh.spring4.x.section15_cache;

import java.lang.annotation.*;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * @author HaoHao
 * @Description: 自定义缓存注解
 * @date 2018/8/24下午5:52
 */

@Caching(cacheable = {
        @Cacheable(value = "adult", condition = "#user.age>18"),
        @Cacheable(value = "children", condition = "#user.age<18")
})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 可被继承的注解
public @interface CustomizeAnnotation {

}
