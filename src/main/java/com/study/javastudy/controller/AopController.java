package com.study.javastudy.controller;

import com.study.javastudy.annotation.LogMe;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${my.config.test.value}")
    private String abc;

    @Value("${jdbc.config.key}")
    private String jdbcKey;

    @Value("${jdbc.config.value}")
    private Integer jdbcValue;

    @LogMe(logParam = true,logReturn = true)
    @RequestMapping("/logTest")
    public String logTest(@RequestParam("userName") String userName){
        System.out.println("userName:" + userName);
        return userName + abc + " jdbc-key:" + jdbcKey + " jdbc-value:" + jdbcValue;
    }
}
