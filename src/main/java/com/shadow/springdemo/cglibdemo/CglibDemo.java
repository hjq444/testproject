package com.shadow.springdemo.cglibdemo;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author Huajq
 * @since 2022-08-01 22:59
 */
public class CglibDemo {

    public static void main(String[] args){
        UserServiceMethodInterceptor userServiceMethodInterceptor = new UserServiceMethodInterceptor();
        //实例化Enhancer类生成器
        Enhancer enhancer = new Enhancer();
        //设置Enhancer要生成的目标类的父类
        enhancer.setSuperclass(UserServiceImp.class);
        //设置目标类执行方法的拦截器
        enhancer.setCallback(userServiceMethodInterceptor);
        //利用enhancer生成目标类 UserServiceImp$$EnhancerByCGLIB$$b2b12b83@6df97b55
        UserServiceImp obj=(UserServiceImp) enhancer.create();
        //生成的目标类调用方法，此时会被userServiceMethodInterceptor拦截，执行其中的intercept方法
        obj.getName(1);
        //生成的目标类调用方法，此时会被userServiceMethodInterceptor拦截，执行其中的intercept方法
        obj.getAge(1);
    }
}
