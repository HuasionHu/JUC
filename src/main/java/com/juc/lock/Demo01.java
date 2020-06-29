package com.juc.lock;

/**
 * Synchronized的可重入锁，至始至终用的都是一把锁
 */
public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sms();
        },"A").start();

        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}

class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"sms");
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"call");
    }
}