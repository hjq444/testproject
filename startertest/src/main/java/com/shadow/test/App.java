package com.shadow.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import test1.StudentService;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        StudentService bean = run.getBean(StudentService.class);
        bean.testStudent();
        System.out.println(bean);

    }
}
