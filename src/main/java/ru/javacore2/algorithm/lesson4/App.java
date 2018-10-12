package ru.javacore2.algorithm.lesson4;

import ru.javacore2.algorithm.lesson3.util.Deque;
import ru.javacore2.algorithm.lesson3.util.Node;

public class App {

    public static void main(String[] args) {
        Deque deque = new Deque(1, 2, 3, 4, 5);
        for (Node node: deque) {
            System.out.println(node.getValue());
        }
    }

}
