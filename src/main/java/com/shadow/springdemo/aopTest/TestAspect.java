package com.shadow.springdemo.aopTest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-07-13 15:51
 */
@Aspect
@Component
public class TestAspect {

    @Before("within(com.shadow.springdemo.aopTest..*)")
    public void Before(JoinPoint point) throws IllegalAccessException {

        // 1.获取需要增强的方法

        // 2.获取方法的参数

        // 3.遍历参数的属性

        // 4.若属性中增加了注解就进行增强

        // 将增加了注解的属性的值取出进行判断，是否有敏感词，若有则报错

        StringBuilder checkContent = new StringBuilder();
        MethodSignature signature = (MethodSignature)point.getSignature();
        System.out.println("----> " + signature);
        Object[] args = point.getArgs();
        Method method = signature.getMethod();
        System.out.println("----> " + method);
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
            Field[] fields = parameterType.getDeclaredFields();
            System.out.println(Arrays.toString(fields));
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getType() == String.class && Objects.nonNull(fields[i].getAnnotation(WordAspect.class))) {
                    fields[i].setAccessible(true);
                    // 获取属性的值
                    checkContent.append(fields[i].get(args[i])).append("敏感词过滤");
                }
            }
        }
        System.out.println(checkContent.toString());

//        String name = signature.getName();
//        System.out.println("-- " + name);
    }
}
