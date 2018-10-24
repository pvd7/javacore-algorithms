package ru.javacore2.algorithm.lesson7;

import ru.javacore2.algorithm.lesson7.example.Graph;

public class App {

    public static void main(String[] args) {
        Graph graph = new Graph(32);
        graph.addVertex('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i');
        graph.addEdge('a', 'b', 7);
        graph.addEdge('a', 'd', 8);
        graph.addEdge('b', 'c', 6);
        graph.addEdge('b', 'f', 10);
        graph.addEdge('c', 'd', 1);
        graph.addEdge('d', 'e', 3);
        graph.addEdge('d', 'f', 8);
        graph.addEdge('e', 'g', 2);
        graph.addEdge('f', 'g', 2);
        graph.addEdge('g', 'h', 15);
        graph.addEdge('h', 'f', 10);
        graph.addEdge('h', 'i', 13);
        graph.addEdge('i', 'a', 20);

        graph.findRoute('a', 'i');
        graph.findRoute('a', 'f');
        graph.findRoute('i', 'e');
        graph.findRoute('d', 'a');
    }

}
