package com.hh.spring4.x.section15_cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HaoHao
 * @Description: 一个简单的缓存管理器,支持对象的增删改查
 * @date 2018/8/24下午4:01
 */
public class CacheManager<T> {

    // 缓存 等价于 redis等缓存数据库
    private Map<String, T> cache = new ConcurrentHashMap<>();

    public T getValue(String key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T v) {
        cache.getOrDefault(key, v);
    }

    // 清除缓存中对应的记录
    public void evictCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    // 清空缓存
    public void evictCache() {
        cache.clear();
    }

}
