package com.shadow.springdemo.cglibdemo;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-01 23:00
 */
public class UserServiceImp {
    public String getName(int id){
        System.out.println("getName()");
        return "Tom";
    }
    public int getAge(int id){
        System.out.println("getAge()");
        return 10;
    }
}
