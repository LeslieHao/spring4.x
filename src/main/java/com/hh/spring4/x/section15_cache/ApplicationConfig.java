package com.hh.spring4.x.section15_cache;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author HaoHao
 * @Description: 等价于一个 xml 配置
 * @date 2018/8/24下午5:31
 */

@Configuration
@ComponentScan(basePackages = {"com.hh.spring4.x.section15_cache"})
@EnableCaching
public class ApplicationConfig {

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("users")));
        return cacheManager;
    }
}
