package com.study.javastudy.controller;

import com.study.javastudy.annotation.LogMe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wentianlou
 * @date 2019/12/4 20:18
 **/
@RestController
@RequestMapping("/aop")
public class AopController {

    @LogMe(logParam = true,logReturn = true)
    @RequestMapping("/logTest")
    public String logTest(@RequestParam("userName") String userName){
        System.out.println("userName:" + userName);
        return userName;
    }
}
