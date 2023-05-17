package com.learn.test.juc;

import java.util.concurrent.locks.ReentrantLock;

public class Test02 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
