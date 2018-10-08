package ru.javacore2.algorithm.lesson3.util;

public class PriorityQueue {

    private int size;
    private int[][] queue;
    private int[][] queue1;
    private int items;

    public PriorityQueue(int size) {
        this.size = size;
        queue = new int[size][2];
//        queue = new int[size][2];
        items = 0;
    }

    public int find(int priority) {
        int i = -1;
        if (queue != null) {
            int low = 0;
            int high = size;
            int middle;
            while (low < high) {
                middle = (low + high) / 2;
                if (priority == queue[middle][1]) {
                    i = middle;
                    break;
                } else {
                    if (priority <= queue[middle][1]) {
                        high = middle;
                    } else {
                        low = middle + 1;
                    }
                }
            }
        }
        return i;
    }

    public void add(int item, int priority) {
    }


    public int remove() {
        return queue[--items][0];
    }

    public long peek() {
        return queue[items - 1][0];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == size);
    }

}
