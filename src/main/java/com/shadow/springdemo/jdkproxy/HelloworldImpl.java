package com.shadow.springdemo.jdkproxy;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-25 10:54
 */
public class HelloworldImpl implements Helloworld{
    @Override
    public void sayHello() {
        System.out.print("hello world");
    }
}
