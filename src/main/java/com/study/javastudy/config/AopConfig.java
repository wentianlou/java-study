package com.study.javastudy.config;

import com.study.javastudy.aop.MethodLogAop;
import com.study.javastudy.plugin.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration : 代表这是一个java配置文件，spring的容器会根据它来生成Ioc容器去装配Bean。
 */
@Configuration
public class AopConfig {

    @Bean
    public MethodLogAop methodLogAop() {
        MethodLogAop methodLogAop = new MethodLogAop();
        methodLogAop.addReturnValueRecorder(new CollectionValueRecorder());
        methodLogAop.addParamValueRecorder(new CollectionValueRecorder());
        methodLogAop.addParamValueRecorder(new ParamValueRecorder());
        methodLogAop.addReturnValueRecorder(new MapValueRecorder());
        methodLogAop.addParamValueRecorder(new MapValueRecorder());
        return methodLogAop;
    }

}
