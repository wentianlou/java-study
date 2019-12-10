package com.study.javastudy.service.impl;

import com.study.javastudy.service.AnimalService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * IOC容器的Bean默认是单列
 * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) :ioc容器再每次获取Bean时都新建一个Bean的实例返回给调用者。
 * @author wentianlou
 * @date 2019/12/7 10:45
 **/
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class DogServiceImpl implements AnimalService {
    @Override
    public void hello() {
        System.out.println("dog");
    }
}
