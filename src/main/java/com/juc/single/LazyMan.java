package com.juc.single;

//懒汉式单例
public class LazyMan {

    private LazyMan(){

    }

    public volatile static LazyMan lazyMan;

    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();//不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法。初始化对象
                     * 3.把这个对象指向这个空间
                     *
                     * 123
                     * 132
                     */
                }
            }
        }
        return lazyMan;
    }
}
