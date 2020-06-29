package com.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock的可重入锁，用的是两把锁
 */
public class Demo02 {
    public static void main(String[] args) {
        Phone phone1 = new Phone();

        new Thread(()->{
            phone1.sms();
        },"A").start();

        new Thread(()->{
            phone1.sms();
        },"B").start();
    }
}

class Phone1{
    Lock lock = new ReentrantLock();
    public synchronized void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
