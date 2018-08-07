package com.yavoric.lesson12.stack;

import com.yavoric.lesson12.stack.EmptyStackException;
import com.yavoric.lesson12.stack.FullStackException;

public interface Stack<T> {
    void push(T element) throws FullStackException; // кладет элемент в вершину стэка
    T pop() throws EmptyStackException;		 // удаляет элемент из вершины стэка и возвращает его. Если стэк пустой - возвращает EmptyStackException
    T peek() throws EmptyStackException;; 		 // возвращает элемент из вершины стэка, но не удаляет его
}