package com.shadow.springdemo.JoinTest;

import java.util.Date;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-27 9:38
 */
public class JoinTest {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println(new Date() + "-线程一");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread thread2 = new Thread(() -> {
            System.out.println(new Date() + "-线程二");
        }, "t2");

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();


    }
}
