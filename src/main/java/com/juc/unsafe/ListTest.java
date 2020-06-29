package com.juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
        //并发下ArrayList不安全的吗，Synchronized；
        /**
         * 解决方案
         * 1.List<String> vector = new Vector<>();
         * 2.List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3.List<String> list = new CopyOnWriteArrayList<>();
         */
        //CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略；
        //多个线程调用的时候，list ，读取的时候， 固定的， 写入（覆盖）
        //读写分离
        //CopyOnWriteArrayList 比Vector Nb 在哪里?
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
     }
}
