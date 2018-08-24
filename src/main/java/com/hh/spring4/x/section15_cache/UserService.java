package com.hh.spring4.x.section15_cache;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hh.spring4.x.entity.UserEntity;

/**
 * @author HaoHao
 * @date 2018/8/24下午4:08
 */

@Service
// 全局的缓存配置
//@CacheConfig(cacheNames = "users",keyGenerator = "MyGenerator")
public class UserService {

    Map<String, UserEntity> users = new HashMap<String, UserEntity>() {{
        put("1", new UserEntity("1", "Kobe", 36));
        put("2", new UserEntity("2", "James", 26));
    }};

    @Autowired
    private CacheManager cacheManager;

//    @Autowired
//    private void setCacheManager(CacheManager cacheManager) {
//        this.cacheManager = cacheManager;
//    }

    // 构造执行之后调用,此时属性已经被注入
    // 将数据在bean 加载时放入缓存
    @PostConstruct
    public void setup(){
        Cache usersCache = cacheManager.getCache("users");
        users.keySet().forEach(s
                -> usersCache.put(s, users.get(s)));
    }


    @Cacheable(value = "users")
    // spring 4.x 新增
//    @Cacheable(cacheNames = "users",condition = "#user.age>18",key = "#user.userName")
    // 多个缓存
//    @Cacheable(cacheNames = {"users2", "users1"})
    public UserEntity getUser(UserEntity user) {
        System.out.println("查询数据库");
        return new UserEntity(user.getUserId(), "Kobe", 37);
    }


    @Cacheable(value = "users")
    public UserEntity getUserById(String  id) {
        System.out.println("查询数据库");
        return new UserEntity(id, "Kobe", 37);
    }

    @CachePut(value = "users")
    public UserEntity getUser2(UserEntity user) {
        System.out.println("查询数据库");
        return new UserEntity(user.getUserId(), "Kobe", 37);
    }


    // allEntries: 是否移除缓存中所有条目
    // beforeInvocation: 调用方法之前移除还是之后移除(如果之后,方法执行异常不会触发清除操作)
    @CacheEvict(cacheNames = "users",allEntries = true,beforeInvocation = true)
    public void deleteUser(UserEntity entity) {

    }
    @CacheEvict("users")
    public void updateUser(UserEntity entity) {

    }


    // 分别根据条件存储在不同的缓存
    @Caching(cacheable = {
            @Cacheable(value = "adult",condition = "#user.age>18"),
            @Cacheable(value = "children",condition = "#user.age<18")
    })
    public UserEntity getUser3(UserEntity user) {
        System.out.println("查询数据库");
        return new UserEntity(user.getUserId(), "Kobe", 37);
    }

}

