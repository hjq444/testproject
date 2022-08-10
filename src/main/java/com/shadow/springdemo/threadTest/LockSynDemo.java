package com.shadow.springdemo.threadTest;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-09 10:49
 */
public class LockSynDemo {

    Object object = new Object();

    public void m1(){
        synchronized (object){
            System.out.println("test");
        }
    }

    public static void main(String[] args) {

    }
}
