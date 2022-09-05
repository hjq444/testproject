package com.shadow.springdemo.threadlocalTest;

public class ThreadlocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        //创建第一个线程
        Thread threadA = new Thread(() -> {
            threadLocal.set("ThreadA：" + Thread.currentThread().getName());
            System.out.println("线程A本地变量中的值为：" + threadLocal.get());
            threadLocal.remove();
            System.out.println("线程A删除本地变量后ThreadLocal中的值为：" + threadLocal.get());
        });

        //创建第二个线程
        Thread threadB = new Thread(() -> {
            threadLocal.set("ThreadB：" + Thread.currentThread().getName());
            System.out.println("线程B本地变量中的值为：" + threadLocal.get());
            System.out.println("线程B没有删除本地变量：" + threadLocal.get());
        });

        //启动线程A和线程B
        threadA.start();
        threadB.start();

    }
}
