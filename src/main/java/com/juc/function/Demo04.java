package com.juc.function;

import java.util.function.Supplier;

public class Demo04 {
    public static void main(String[] args) {
        Supplier supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("get()");
                return 1024;
            }
        };
        Supplier supplier1 = ()->{return 1024;};
        System.out.println(supplier1.get());
    }
}
