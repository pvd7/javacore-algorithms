package ru.javacore2.algorithm.lesson1;

import org.junit.Assert;
import org.junit.Test;


public class AppTest {
    private int[] arr1 = {1, 3, 4, 5, 7, 5, 4, -1};
    private int[] arr2 = {1, 3, 4, 5, 7, 5, 4};
    private int[] arr3 = {};
    private int[] arr4 = {5};

    @Test
    public void pow() {
        Assert.assertEquals(1.0, App.pow(2.0, 0), 0.0);
        Assert.assertEquals(2.0, App.pow(2.0, 1), 0.0);
        Assert.assertEquals(3125.0, App.pow(5.0, 5), 0.0);
        Assert.assertEquals(131072.0, App.pow(2, 17), 0.0);
    }

    @Test
    public void minArr() {
        Assert.assertEquals(-1, App.minArr(arr1));
        Assert.assertEquals(1, App.minArr(arr2));
        Assert.assertEquals(0, App.minArr(arr3));
        Assert.assertEquals(5, App.minArr(arr4));
    }

    @Test
    public void avgArr() {
        Assert.assertEquals(3.5, App.avgArr(arr1), 0.0);
        Assert.assertEquals(4.142, App.avgArr(arr2), 0.001);
        Assert.assertEquals(0.0, App.avgArr(arr3), 0.0);
        Assert.assertEquals(5.0, App.avgArr(arr4), 0.0);
    }

}