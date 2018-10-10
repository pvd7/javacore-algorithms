package ru.javacore2.algorithm.lesson3.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void peek() {
        PriorityQueue queue = new PriorityQueue();
        queue.add(10, Priority.HIGHEST);
        queue.add(2, Priority.HIGHEST);
        queue.add(3, Priority.LOW);
        queue.add(30, Priority.LOW);
        queue.add(40, Priority.NORMAL);
        queue.add(41, Priority.NORMAL);
        queue.add(515);
        queue.add(51);
        Assert.assertEquals(10, queue.peek());
    }

    @Test
    public void remove() {
        PriorityQueue queue = new PriorityQueue();
        queue.add(10, Priority.HIGHEST);
        queue.add(2, Priority.HIGHEST);
        queue.add(3, Priority.LOW);
        queue.add(30, Priority.LOW);
        queue.add(40, Priority.NORMAL);
        queue.add(41, Priority.NORMAL);
        queue.add(515);
        queue.add(51);
        Assert.assertEquals(10, queue.remove());
        Assert.assertEquals(2, queue.remove());
        Assert.assertEquals(40, queue.remove());
        Assert.assertEquals(41, queue.remove());
        Assert.assertEquals(515, queue.remove());
        Assert.assertEquals(51, queue.remove());
        Assert.assertEquals(3, queue.remove());
        Assert.assertEquals(30, queue.remove());
    }

    @Test
    public void length() {
        int len = Priority.values().length;
        int[] size = new int[len];
        int num;
        int sumSize = 0;
        Priority[] priorities = Priority.values();
        PriorityQueue queue = new PriorityQueue();
        for (Priority priority: priorities) {
            num = priority.ordinal();
            size[num] = (int) (1000 * Math.random());
            sumSize += size[num];
            for (int j = 0; j < size[num]; j++) {
                queue.add(j, priority);
            }
        }
        Assert.assertEquals(sumSize, queue.length());
        Assert.assertEquals(size[len - 1], queue.lengthQueue());
        Assert.assertEquals(size[Priority.HIGHEST.ordinal()], queue.lengthQueue(Priority.HIGHEST));
        Assert.assertEquals(size[Priority.HIGH.ordinal()], queue.lengthQueue(Priority.HIGH));
        Assert.assertEquals(size[Priority.NORMAL.ordinal()], queue.lengthQueue(Priority.NORMAL));
        Assert.assertEquals(size[Priority.LOW.ordinal()], queue.lengthQueue(Priority.LOW));
    }

}