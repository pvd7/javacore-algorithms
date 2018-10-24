package ru.javacore2.algorithm.lesson7.example;

import ru.javacore2.algorithm.lesson3.example.Queue;
import ru.javacore2.algorithm.lesson3.example.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Graph {

    private class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return "V: " + label;
        }
    }

    private final int MAX_VERTICES;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;

    public Graph(int maxVertices) {
        this.MAX_VERTICES = maxVertices;
        vertices = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
//        routeMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size = 0;
    }

    public void addVertex(char... labels) {
        for (char label : labels) addVertex(label);
    }

    public int addVertex(char label) {
        vertices[size++] = new Vertex(label);
        return size - 1;
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
    }

    public void addEdge(char start, char end, int weight) {
        int s = find(start);
        if (s == -1) s = addVertex(start);

        int e = find(end);
        if (e == -1) e = addVertex(end);

        adjMatrix[s][e] = weight;
    }

    private int find(char vertex) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].label == vertex) return i;
        }
        return -1;
    }

    /**
     * Заполняет массив путей и весов
     *
     * @param weight массив весов
     * @param route  массив путей (в route[i] хранится из какого узла в него пришли)
     * @param vertex узел с от которого строим маршрут
     */
    private void makeRouters(int[] weight, int[] route, int vertex) {
        vertices[vertex].wasVisited = true;

        int w;
        for (int i = 0; i < size; i++) {
            if ((vertex != i) && (adjMatrix[vertex][i] > 0)) {
                w = weight[vertex] + adjMatrix[vertex][i];
                if (weight[i] == 0 || weight[i] > w) {
                    weight[i] = w;
                    route[i] = vertex;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (!vertices[i].wasVisited && (adjMatrix[vertex][i] > 0)) {
                makeRouters(weight, route, i);
            }
        }
    }

    /**
     * Ищет кратчайший путь
     *
     * @param start начальный узел
     * @param end   конечный узел
     */
    public void findRoute(char start, char end) {
        for (int i = 0; i < size; i++) vertices[i].wasVisited = false;

        int s = find(start);
        if (s == -1) throw new RuntimeException("label '" + start + "' not found!");

        int e = find(end);
        if (e == -1) throw new RuntimeException("label '" + end + "' not found!");

        int[] weight = new int[size];
        int[] route = new int[size];
        makeRouters(weight, route, s);

        System.out.printf("%s -> %s = %2d", start, end, weight[e]);
//        System.out.println();

        if (weight[e] > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(vertices[e].label);
            int i = e;
            while (i != s) {
                i = route[i];
                sb.insert(0, vertices[i].label + " -> ");
            }
//            sb.append(" = " + weight[e]);
            System.out.println(" [" + sb.toString() + "]");
        }

//        System.out.println();
//        System.out.println(Arrays.toString(route));
//        System.out.println(Arrays.toString(weight));
//        for (int i = 0; i < size; i++) {
//            System.out.printf("%s -> %s = %2d", start, vertices[i].label, weight[i]);
//            System.out.println();
//        }
    }

    public void printVertex(int vertex) {
        System.out.print(vertices[vertex] + " ");
    }

    private int getUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertices[i].wasVisited)
                return i;
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public void depthTravers() {
        Stack stack = new Stack(MAX_VERTICES);
        vertices[0].wasVisited = true;
        printVertex(0);
        stack.insert(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.remove();
            } else {
                vertices[v].wasVisited = true;
                printVertex(v);
                stack.insert(v);
            }
        }
        resetFlags();
    }

    public void widthTravers() {
        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        printVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()) {
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1) {
                vertices[vNext].wasVisited = true;
                printVertex(vNext);
                queue.insert(vNext);
            }
        }
        resetFlags();
    }

}
