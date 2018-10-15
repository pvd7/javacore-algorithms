package ru.javacore2.algorithm.lesson3.util;

import org.junit.Assert;
import org.junit.Test;

public class DequeIteratorTest {

    @Test
    public void hasNext() {
        DequeIterator itr = new DequeIterator(new Deque(1, 2, 3, 4));
        Assert.assertTrue(itr.hasNext());
        itr.insert(1);
        Assert.assertTrue(itr.hasNext());
    }

    @Test
    public void next() {
        DequeIterator itr = new DequeIterator(new Deque(1, 2, 3, 4));
        Assert.assertEquals(1, itr.next().getValue());
        Assert.assertEquals(2, itr.next().getValue());
        Assert.assertEquals(3, itr.next().getValue());
        Assert.assertEquals(4, itr.next().getValue());
        Assert.assertNull(itr.next());
    }

    @Test
    public void remove() {
        DequeIterator itr = new DequeIterator(new Deque(1, 2, 3, 4));
        itr.remove();
        Assert.assertEquals(2, itr.getNode().getValue());
        itr.remove();
        Assert.assertEquals(3, itr.getNode().getValue());
        itr.remove();
        Assert.assertEquals(4, itr.getNode().getValue());
        itr.remove();
        Assert.assertNull(itr.getNode());
    }

    @Test
    public void insert() {
        DequeIterator itr = new DequeIterator(new Deque(1, 2, 3, 4));
        itr.insert(10);
        itr.insert(11);
        itr.next();
        itr.insert(20);
        Assert.assertEquals("[11, 20, 10, 1, 2, 3, 4]", itr.toString());
    }

}