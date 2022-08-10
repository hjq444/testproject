package com.shadow.springdemo.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-08 15:16
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock locktest = new ReentrantLock();
        try {
            locktest.lock();
        }finally {
            locktest.unlock();
        }
    }
}
