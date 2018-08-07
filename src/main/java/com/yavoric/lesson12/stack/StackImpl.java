package com.yavoric.lesson12.stack;

import com.yavoric.lesson12.stack.EmptyStackException;
import com.yavoric.lesson12.stack.FullStackException;
import com.yavoric.lesson12.stack.Stack;

public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int pointer = -1;

    public StackImpl(T[] array) {
        this.array = array;
    }

    @Override
    public void push(T element) throws FullStackException {
        if (pointer == array.length-1)
            throw new FullStackException("To large pointer: " + pointer);

        // pointer++;
        array[++pointer] = element;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (pointer == -1)
            throw new EmptyStackException();
        return array[pointer--];
    }

    @Override
    public T peek() throws EmptyStackException {
        if (pointer == -1)
            throw new EmptyStackException();

        return array[pointer];
    }
}
