package ru.javacore2.algorithm.lesson3.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void addTail() {
        Deque deque;

        deque = new Deque();
        deque.addTail(1);
        Assert.assertEquals(1, deque.peekHead());
        Assert.assertEquals(1, deque.peekTail());
        deque.addTail(3);
        Assert.assertEquals(1, deque.peekHead());
        Assert.assertEquals(3, deque.peekTail());
        deque.addTail(3);
        deque.addTail(34);
        deque.addTail(35);
        Assert.assertEquals(35, deque.peekTail());

        deque = new Deque(1, 3, 4, 5);
        deque.addTail(1);
        Assert.assertEquals(1, deque.peekHead());
        Assert.assertEquals(1, deque.peekTail());
        deque.addTail(3);
        Assert.assertEquals(1, deque.peekHead());
        Assert.assertEquals(3, deque.peekTail());
        deque.addTail(3);
        deque.addTail(34);
        deque.addTail(35);
        Assert.assertEquals(35, deque.peekTail());
    }

    @Test
    public void addHead() {
        Deque deque;

        deque = new Deque();
        deque.addHead(1);
        Assert.assertEquals(1, deque.peekHead());
        Assert.assertEquals(1, deque.peekTail());
        deque.addHead(3);
        Assert.assertEquals(3, deque.peekHead());
        Assert.assertEquals(1, deque.peekTail());
        deque.addHead(3);
        deque.addHead(34);
        deque.addHead(35);
        Assert.assertEquals(35, deque.peekHead());

        deque = new Deque(1, 3, 4, 5);
        deque.addHead(1);
        Assert.assertEquals(1, deque.peekHead());
        Assert.assertEquals(5, deque.peekTail());
        deque.addHead(3);
        Assert.assertEquals(3, deque.peekHead());
        Assert.assertEquals(5, deque.peekTail());
        deque.addHead(3);
        deque.addHead(34);
        deque.addHead(35);
        Assert.assertEquals(35, deque.peekHead());
    }

    @Test
    public void removeTail() {
        Deque deque = new Deque(1, 3, 4, 5);
        Assert.assertEquals(5, deque.removeTail());
        Assert.assertEquals(4, deque.peekTail());
        Assert.assertEquals("[1, 3, 4]", deque.toString());
    }

    @Test
    public void removeHead() {
        Deque deque = new Deque(1, 3, 4, 5);
        Assert.assertEquals(1, deque.removeHead());
        Assert.assertEquals(3, deque.peekHead());
        Assert.assertEquals("[3, 4, 5]", deque.toString());
    }

    @Test
    public void isEmpty() {
        Deque deque = new Deque(1, 3, 4, 5);
        Assert.assertFalse(deque.isEmpty());
        deque.clear();
        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void clear() {
        Deque deque = new Deque();
        deque.clear();
        Assert.assertTrue(deque.isEmpty());
        deque.addHead(1);
        deque.clear();
        Assert.assertTrue(deque.isEmpty());
    }

}