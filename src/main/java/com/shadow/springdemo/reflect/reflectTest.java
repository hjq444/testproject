package com.shadow.springdemo.reflect;

import java.lang.reflect.Constructor;

/**
 * @author: Huajq
 * @description: 反射demo
 * @date: 2022-06-23 9:21
 */
public class reflectTest {
    public static void main(String[] args) throws Exception {
        Class<Student> clazz = Student.class;
        Constructor<Student> studentConstructor = clazz.getDeclaredConstructor();
        Student student = studentConstructor.newInstance();
        student.setAge(10);
        student.setName("小白");
        student.setWeight(70);
        student.setHigh(180);
        System.out.println(student);
    }
}
