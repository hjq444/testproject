package com.shadow.springdemo.aopTest;

import org.springframework.stereotype.Component;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-07-13 16:02
 */
@Component
@WordAspect
public class BuyCat implements Buy{

    @Override
    public String buy(Cat cat) {
        return cat.getName();
    }
}
