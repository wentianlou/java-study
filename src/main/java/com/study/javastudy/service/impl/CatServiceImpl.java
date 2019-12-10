package com.study.javastudy.service.impl;

import com.study.javastudy.service.AnimalService;
import org.springframework.stereotype.Service;

/**
 * @author wentianlou
 * @date 2019/12/7 10:46
 **/
@Service
public class CatServiceImpl implements AnimalService {
    @Override
    public void hello() {
        System.out.println("cat");
    }
}
