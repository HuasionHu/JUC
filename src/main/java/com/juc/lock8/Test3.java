package com.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 5、 增加两个静态的同步方法,只有一个对象，先打 印发短信 还是 打电话？
 * 6. 两个对象！增加两个静态的同步方法，先打印 发短信 还是 打电话？
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone = new Phone3();
        Phone3 phone1 = new Phone3();

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

//Phone3唯一的一个Class对象
class Phone3{

    //synchronized 锁的对象是方法的调用者！
    //static 静态方法
    //类一加载就有了！Class模板
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }
}
