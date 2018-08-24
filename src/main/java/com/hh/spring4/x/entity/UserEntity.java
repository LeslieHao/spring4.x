package com.hh.spring4.x.entity;

import java.io.Serializable;

/**
 * @author HaoHao
 * @Description: 通用用户实体(缓存需要序列化)
 * @date 2018/8/24下午3:55
 */
public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4900939455542670880L;

    private String userId;

    private String userName;

    private int age;

    public UserEntity(String userId, String userName, int age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    public UserEntity() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
