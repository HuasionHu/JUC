package com.juc.stream;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(6,"e",25);
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        //计算交给Stream流
        //lambda表达式、链式编程、函数时接口、Stream流式计算（本篇都有）
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(user -> {return user.getAge()>23;})
                .map(user -> {return user.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(1)
                .forEach(System.out::println);
    }
}
