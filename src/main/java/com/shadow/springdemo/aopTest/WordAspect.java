package com.shadow.springdemo.aopTest;

import java.lang.annotation.*;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-07-13 15:56
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WordAspect {
}
