package com.shadow.springdemo.spiTest;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-01 10:08
 */
public class Dog implements Animal{
    @Override
    public void test() {
        System.out.println("狗");
    }
}
