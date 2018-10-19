package ru.javacore2.algorithm.lesson6.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void isBalanced() {
        Tree tree = new Tree();
        tree.insert(5);
        Assert.assertTrue(tree.isBalanced());
        tree.insert(3);
        Assert.assertTrue(tree.isBalanced());
        tree.insert(2);
        Assert.assertFalse(tree.isBalanced());
        tree.insert(1);
        tree.insert(4);
        Assert.assertFalse(tree.isBalanced());
        tree.insert(7);
        Assert.assertTrue(tree.isBalanced());
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        Assert.assertTrue(tree.isBalanced());
        tree.insert(10);
        Assert.assertFalse(tree.isBalanced());
    }

}