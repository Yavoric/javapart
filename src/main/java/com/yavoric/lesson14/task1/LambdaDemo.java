package com.yavoric.lesson14.task1;
import java.util.*;
import java.lang.*;
public class LambdaDemo {
    public static void main(String[] args) {
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);

    }
}