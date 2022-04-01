package com.learn.test.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    public static void main(String[] args) {
        //ThreadPoolExecutor 源码
        //Lock源码
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(12, 12, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

    }
}
