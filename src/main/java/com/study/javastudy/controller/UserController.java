package com.study.javastudy.controller;

import com.study.javastudy.annotation.LogMe;
import com.study.javastudy.entity.User;
import com.study.javastudy.service.AnimalService;
import com.study.javastudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /**
     * Qualifier注解：在有多个类型相同的bean的时候指定某一个bean注入
     */
    @Autowired
    @Qualifier(value = "dogServiceImpl")
    private AnimalService animalService;

    @Autowired
    @Qualifier(value = "dogServiceImpl")
    private AnimalService animalService1;

    @LogMe(logParam = true,logReturn = true)
    @RequestMapping("/getUser")
    public User getUser(@RequestParam("userId") Integer userId){
        return userService.getUser(userId);
    }

    @RequestMapping("/animal")
    public String typeTest(){
        animalService.hello();
        return "ok";
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println(animalService == animalService1);
        return "ok";
    }
}
