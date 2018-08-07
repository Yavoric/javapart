package com.yavoric.lesson12.queue;

//import com.yavoric.lesson12.queue.FullQueueException;

public interface Queue<T> {
    void add(T element); // помещает элемент в конец очереди
    T pol();//достает и удаляет элемент из очереди, который зашел самым первым. Если очередь пуста - возвращает null
    T remove();//достает и удаляет элемент из очереди, который зашел самым первым. Если очередь пуста - бросает NoSuchElementException
    T peek() ;	 // возвращает первый элемент из очереди, но не удаляет его. Если очередь пуста - возвращает null
    T element();//// выдает первый элемент на очереди, но не удаляет его.Если очередь пуста - бросает NoSuchElementException
}