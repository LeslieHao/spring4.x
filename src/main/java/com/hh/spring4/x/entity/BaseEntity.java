package com.hh.spring4.x.entity;

import com.alibaba.fastjson.JSON;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/8/24下午4:23
 */
public class BaseEntity {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
