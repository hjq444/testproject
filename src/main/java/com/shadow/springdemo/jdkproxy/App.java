package com.shadow.springdemo.jdkproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-25 10:55
 */
public class App {
    public static void main(String[] args) throws Exception {
        // 传入三大参数，就能够创建出一个代理对象
        Helloworld helloWorld = (Helloworld) Proxy.newProxyInstance(
                Helloworld.class.getClassLoader(),
                new Class<?>[]{Helloworld.class},
                new MyInvocationHandler(new HelloworldImpl())); //此处目标实现为HelloworldImpl
        helloWorld.sayHello();
    }
}
