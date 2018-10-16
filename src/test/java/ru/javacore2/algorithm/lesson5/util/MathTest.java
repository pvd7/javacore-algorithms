package ru.javacore2.algorithm.lesson5.util;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {

    @Test
    public void pow() {
        Assert.assertEquals(1.0, Math.pow(2.0, 0), 0.0);
        Assert.assertEquals(2.0, Math.pow(2.0, 1), 0.0);
        Assert.assertEquals(3125.0, Math.pow(5.0, 5), 0.0);
        Assert.assertEquals(131072.0, Math.pow(2, 17), 0.0);
    }

}