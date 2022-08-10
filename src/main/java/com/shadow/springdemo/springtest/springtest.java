package com.shadow.springdemo.springtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-05 17:00
 */
public class springtest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = applicationContext.getBean(AppConfig.class);
        bean.getTest();
        System.out.println(bean);

    }
}
