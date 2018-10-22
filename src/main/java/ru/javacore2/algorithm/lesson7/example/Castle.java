package ru.javacore2.algorithm.lesson7.example;

public class Castle {

    public static void main(String[] args) {
        Graph g = new Graph(32);
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addVertex('h');
        g.addVertex('i');
        g.addVertex('j');
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 0);
        g.addEdge(2, 5);
        g.addEdge(5, 6);
        g.addEdge(3, 7);
        g.addEdge(6, 8);
        g.addEdge(6, 9);
        g.addEdge(7, 9);

        g.depthTravers();
        System.out.println();
        g.widthTravers();
    }

}