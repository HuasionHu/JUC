package com.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    //CAS compareAndSet ：比较并交换！
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //期望、更新
        //public final boolean compareAndSet(int expect, int update)
        //如果我期望的值达到了没那么就更新，否则，就不更新，CAS 是CPU的并发原语
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger.get());
    }
}
