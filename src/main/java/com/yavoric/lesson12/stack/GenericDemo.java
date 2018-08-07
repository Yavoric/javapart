package com.yavoric.lesson12.stack;

public class GenericDemo {
    public static void main(String[] args) {
        stackDemo();
    }

    private static void stackDemo() {
        Integer[] arr = new Integer[10];
        Stack<Integer> stackInt = new StackImpl<>(arr);
        Integer n = null;
        try {
            stackInt.push(12);
            stackInt.push(11);
            stackInt.push(14);
            n = stackInt.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }

    public static void common() {
        double res1 = add(1, 2.1);
        System.out.println(res1);
    }

    public static <T extends Number, S extends Number> double add(T n1, S n2) {
        return n1.doubleValue() + n2.doubleValue();
    }
}
