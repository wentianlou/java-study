package com.study.javastudy.controller;

import com.study.javastudy.annotation.LogMe;
import com.study.javastudy.entity.User;
import com.study.javastudy.service.UserService;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wentianlou
 * @date 2019/12/6 11:32
 **/
@RestController
@RequestMapping("/user")
@EnableCaching
public class UserController {
    @Resource
    private UserService userService;

    @LogMe(logParam = true,logReturn = true)
    @RequestMapping("/getUser")
    public User getUser(@RequestParam("userId") Integer userId){
        return userService.getUser(userId);
    }
}
