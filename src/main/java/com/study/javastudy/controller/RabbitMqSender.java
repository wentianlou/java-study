package com.study.javastudy.controller;

import com.study.javastudy.annotation.LogMe;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wentianlou
 * @date 2020/1/3 17:06
 **/
@RestController
@RequestMapping("/rabbit")
public class RabbitMqSender {
    @Autowired
    private AmqpTemplate template;

    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName;

    @Value("${rabbitmq.queue.user}")
    private String userQueueName;

    @LogMe(logParam = true,logReturn = true)
    @RequestMapping("/sendMsg")
    public void sendMsg(String msg) {
        template.convertAndSend(msgQueueName,msg);
    }
}
