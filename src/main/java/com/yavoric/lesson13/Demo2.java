package com.yavoric.lesson13;
import java.util.*;
public class Demo2 {
    public static void main(String[] args) {
        //a) создать список целых чисел
        List<Integer> listNumber = new ArrayList<>();
        //b) наполнить список случайными целыми числами от 1 до 100 (размер списка 20 элементов)
        for(int i =0; i<20; i++){
            listNumber.add(1+(int)( Math.random()*100));
        }
        //c) вывести список на экран
        System.out.println(" Список  после удаления  имен: "+listNumber);
        //d) вывести минимальное, максимально значения
        System.out.println("Минимальное число="+Collections.min(listNumber)+ " Максимальное число="+
                           Collections.max(listNumber) );
        //e) вывести сумму чисел на экран
        int sum =0;
       for (int i = 0; i<20;i++) {
           sum = sum + listNumber.get(i);
       }
        System.out.println("Сумма элементов ="+sum);
       //f) найти наиболее часто встречающееся число, вывести это число и кол-во повторений на экран
        //		(если чисел несколько с одинаковой частотой повторений, то вывести минимальное из них)
        Collections.sort(listNumber);
        System.out.println("Список отсортирован по А дл Я: "+listNumber);
        int p =0;
        HashMap hm = new HashMap();
        for (int i = 0; i < listNumber.size(); i++) {
            for (int j = i+1; j < listNumber.size(); j++) {
                if (listNumber.get(i).equals(listNumber.get(j))) {
                    p++;
                }
            }
            if (p!=0) {hm.put(listNumber.get(i),++p);}
            p=0;
        }
        System.out.println("Наиболее часто встречающееся число"+hm);
    }
    }


