package ru.javacore2.algorithm.lesson4;

import ru.javacore2.algorithm.lesson3.util.Deque;
import ru.javacore2.algorithm.lesson3.util.Node;

import java.util.Iterator;

public class DequeIterator implements Iterator<Deque> {

    private final Deque deque;
    private Node node;

    public DequeIterator(Deque deque) {
        this.deque = deque;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Deque next() {
        return null;
    }

    @Override
    public void remove() {

    }


}
