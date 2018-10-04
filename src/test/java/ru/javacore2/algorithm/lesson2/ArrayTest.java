package ru.javacore2.algorithm.lesson2;

import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {

    @Test
    public void sortBubble() {
        Array actual1 = new Array(1, 5, 43, 2, 5, 0, 6, 3);
        Array expected1 = new Array(0, 1, 2, 3, 5, 5, 6, 43);
        actual1.sortBubble();
        Assert.assertEquals(expected1.toString(), actual1.toString());
    }

    @Test
    public void sortCounting() {
        Array actual1 = new Array(1, 5, 43, 2, 5, 0, 6, 3);
        Array expected1 = new Array(0, 1, 2, 3, 5, 5, 6, 43);
        actual1.sortCounting();
        Assert.assertEquals(expected1.toString(), actual1.toString());

        Array actual2 = new Array(4, 5, 0, 7, 7, 7, 7, 7, 7);
        Array expected2 = new Array(0, 4, 5, 7, 7, 7, 7, 7, 7);
        actual2.sortCounting();
        Assert.assertEquals(expected2.toString(), actual2.toString());

        Array actual3 = new Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        Array expected3 = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        actual3.sortCounting();
        Assert.assertEquals(expected3.toString(), actual3.toString());

        Array actual4 = new Array();
        Array expected4 = new Array();
        actual4.sortCounting();
        Assert.assertEquals(expected4.toString(), actual4.toString());

        Array actual5 = new Array(6,7,4,3);
        Array expected5 = new Array(1);
        actual5.sortCounting();
        Assert.assertNotEquals(expected5.toString(), actual5.toString());
    }

    @Test
    public void delete() {
        Array expected1 = new Array(1, 5, 2, 5, 0, 6, 3);
        Array actual1 = new Array(1, 5, 43, 2, 5, 0, 6, 3);
        actual1.delete(2);
        Assert.assertEquals(expected1.toString(), actual1.toString());

        Array expected2 = new Array();
        Array actual2 = new Array(new int[]{1});
        actual2.delete(0);
        Assert.assertEquals(expected2.toString(), actual2.toString());
    }

    @Test
    public void deleteAllByValue() {
        Array expected1 = new Array(1, 5, 2, 5, 0, 6, 3);
        Array actual1 = new Array(1, 5, 43, 2, 5, 0, 6, 3);
        actual1.deleteAll(43);
        Assert.assertEquals(expected1.toString(), actual1.toString());

        Array expected2 = new Array(5, 43, 2, 5, 6, 3);
        Array actual2 = new Array(1, 5, 43, 2, 5, 1, 6, 3);
        actual2.deleteAll(1);
        Assert.assertEquals(expected2.toString(), actual2.toString());

        Array expected3 = new Array();
        Array actual3 = new Array(1, 1);
        actual3.deleteAll(1);
        Assert.assertEquals(expected3.toString(), actual3.toString());

        Array expected4 = new Array();
        Array actual4 = new Array();
        actual4.deleteAll(1);
        Assert.assertEquals(expected4.toString(), actual4.toString());
    }

    @Test
    public void deleteAll() {
        Array expected1 = new Array();
        Array actual1 = new Array(1, 5, 43, 2, 5, 0, 6, 3);
        actual1.deleteAll();
        Assert.assertEquals(expected1.toString(), actual1.toString());
    }

}