package com.study.javastudy.entity;

import java.io.Serializable;

/**
 * @author wentianlou
 * @date 2019/12/6 11:25
 **/
public class User implements Serializable {
    private Integer userId;
    private String userName;

    public User() {
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
