package com.shadow.springdemo.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: Huajq
 * @description: FutureTaskTest
 * @date: 2022-06-09 9:30
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(
            new Callable<String>() {
                @Override
                public String call() {
                    System.out.println("执行线程中的内容");
                    return "返回值";
                }
            });

        futureTask.run();
        System.out.println(futureTask.get());
    }
}
