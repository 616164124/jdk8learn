package com.learn.test.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    public static void main(String[] args) {
        //ThreadPoolExecutor 源码
        //Lock源码
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(12, 12, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        threadPoolExecutor.execute(new Runnable() {
           @Override
           public void run() {
               System.out.println("12");
           }
       });

        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        try {
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown();
    }
}
