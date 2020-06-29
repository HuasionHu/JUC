package com.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 *7.1个静态的同步方法，1个普通的同步方法， 一个对象，先打印 发短信 还是 打电话？
 * 8.
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone1 = new Phone4();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone1.call();
        },"B").start();
    }
}

class Phone4{

    //静态的同步方法 锁的是Class模板
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //普通的同步方法 锁的调用者
    public synchronized void call(){
        System.out.println("打电话");
    }

}
