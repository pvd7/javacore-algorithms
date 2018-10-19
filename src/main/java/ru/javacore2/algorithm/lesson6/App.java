package ru.javacore2.algorithm.lesson6;

import ru.javacore2.algorithm.lesson6.util.Tree;

public class App {

    public static void main(String[] args) {
        int len = 20;
        Tree[] trees = new Tree[len];

        Tree tree;
        int size = 100;
        for (int i = 0; i < len; i++) {
            tree = new Tree();
            trees[i] = tree;
            for (int j = 0; j < size; j++) {
                tree.insert((int) (Math.random() * 100));
            }

            System.out.printf("%3d min: %3d, max: %3d, balanced: %b \n", i, tree.getMin(), tree.getMax(), tree.isBalanced());
        }
    }

}
