package com.study.javastudy.service.impl;

import com.study.javastudy.entity.User;
import com.study.javastudy.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wentianlou
 * @date 2019/12/6 11:30
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Cacheable(cacheNames = "user")
    public User getUser(Integer userId) {
        System.out.println("UserServiceImpl#getUser userId=" + userId);
        return new User(userId,"aa");
    }
}
