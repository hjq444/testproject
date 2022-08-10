package com.shadow.springdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-23 9:48
 */
public class TestHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke=null;
        System.out.println(method.getName());
        if ("getName".equals(method.getName())){
            System.out.println("先背书");
            //3.注意这里执行的是原始的对象而不是代理出来的对象
            invoke = method.invoke(method, args);
            System.out.println(invoke);
            System.out.println("考试取得好成绩");
        }else {
            invoke = method.invoke(method, args);
        }
        return invoke;
    }
}
