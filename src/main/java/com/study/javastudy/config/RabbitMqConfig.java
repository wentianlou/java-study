package com.study.javastudy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * @author wentianlou
 * @date 2020/1/3 11:29
 **/
@Configuration
public class RabbitMqConfig {
    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName;

    @Value("${rabbitmq.queue.user}")
    private String userQueueName;

    @Bean
    public Queue queue() {
        return new Queue(msgQueueName,true);
    }

}
