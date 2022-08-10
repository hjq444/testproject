package com.shadow.springdemo.aopTest;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-07-13 16:30
 */
public class Cat {

    public Cat() {
    }

    @WordAspect
    private String name;

    private Integer age;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
