package com.study.javastudy.service.impl;

import com.study.javastudy.service.ActiveMqService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wentianlou
 * @date 2019/12/11 14:26
 **/
@Service
public class ActiveMqServiceImpl implements ActiveMqService {

    @Override
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMsg(String message) {
        System.out.println("java-study接收到消息[" + message + "]");
    }
}
