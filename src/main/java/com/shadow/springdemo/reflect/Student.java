package com.shadow.springdemo.reflect;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-23 9:23
 */
public class Student {

    private String name;

    private Integer age;

    private Integer weight;

    private Integer high;

    public Student() {
    }

    public Student(String name, Integer age, Integer weight, Integer high) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.high = high;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", high=" + high +
                '}';
    }
}
