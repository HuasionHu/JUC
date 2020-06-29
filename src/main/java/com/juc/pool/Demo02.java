package com.juc.pool;

import java.util.concurrent.*;
//4种拒绝策略

/**
 * ThreadPoolExecutor.AbortPolicy() //银行满了，还有人进来，不处理这个人， 抛出异常
 * ThreadPoolExecutor.CallerRunsPolicy() //满了知乎 哪来的去哪里
 * DiscardPolicy() //队列满了就丢掉任务 ，不会抛出异常
 * ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会抛出异常！
 */
public class Demo02 {
    public static void main(String[] args) {
        //自定义线程池！工作 ThreadPoolExecutor

        //最大线程到底该如何定义
        //1.CPU 密集型， 几核，就是几，可以保持CPU的效率最高
        //2.IO 密集型  判断你程序中十分耗IO的线程
        //      程序 15个大型任务 io十分占用资源！
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()); //银行满了，还有人进来，不处理这个人， 抛出异常
        try {
            //最大承载数：Deque + max
            for (int i = 1; i <= 9; i++) {
                //使用了线程池之后，使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}
