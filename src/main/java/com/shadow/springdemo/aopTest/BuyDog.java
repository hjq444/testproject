package com.shadow.springdemo.aopTest;

import org.springframework.stereotype.Component;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-03 16:07
 */
@Component
public class BuyDog implements Buy{
    @Override
    public String buy(Cat cat) {
        return cat.getName();
    }
}
