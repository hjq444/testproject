package com.shadow.springdemo.springtest;

import org.springframework.context.annotation.Configuration;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-05 17:01
 */
// @Configuration
public class AppConfig {
    private int test;

    public int getTest() {
        System.out.println(1);
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
