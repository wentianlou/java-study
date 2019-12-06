package com.study.javastudy.service;

import com.study.javastudy.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author wentianlou
 * @date 2019/12/6 11:21
 **/
public interface UserService {

    User getUser(Integer userId);
}
