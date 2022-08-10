package com.shadow.springdemo.threadTest;

import java.util.concurrent.TimeUnit;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-09 10:00
 */
class Phone {

    public synchronized void sendEmail() {
        try {TimeUnit.MILLISECONDS.sleep(300);}catch (InterruptedException e){System.out.println(e.getMessage());}
        System.out.println("--------sendEmail");
    }

    public synchronized void sendSms() {
        System.out.println("--------sendSMS");
    }

    public void hello(){
        System.out.println("--------hello");
    }
}


public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(phone::sendEmail,"a").start();
        try {TimeUnit.MILLISECONDS.sleep(200);}catch (InterruptedException e){System.out.println(e.getMessage());}
        new Thread(phone::sendSms,"b").start();
    }
}
