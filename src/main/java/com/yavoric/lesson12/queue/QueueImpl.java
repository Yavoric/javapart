package com.yavoric.lesson12.queue;

import com.yavoric.lesson12.queue.Queue;


public class QueueImpl<T> implements Queue<T> {

    private T[] array;
    private T dddd;
    private int pointer = -1;
    //private int pointer1 = 0;

   public QueueImpl(T[] array) {
        this.array = array;
    }

    public void add(T element)  {
        if (pointer == array.length-1)
            System.out.println("Превышенна длинна очереди ");

        // pointer++;
        array[++pointer] = element;
    }
    public T pol() {
       if (pointer == -1)
           System.out.println("Очередь пуста");
       pointer = 0;
       dddd = array[pointer];
       for (int i = 0; i<array.length; i++) {
           array[i] = array[i + 1];
           i--;
       }
           return dddd;

    }

    public T remove() {
        System.out.println("метод в разработке");
        return  array[pointer];
    }

    public T peek() {if (pointer == -1)
        System.out.println("Очередь пуста");
        pointer = 0;
        return array[pointer];
    }
    public T element() {
        return array[pointer];
    }
}
