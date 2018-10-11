package ru.javacore2.algorithm.lesson3.util;

/**
 * Узел очереди
 */
public class Node {
    Object value; // значение
    Node prev; // указатель на предидущий узел
    Node next; // указатель на следующий узел

    Node(Object value) {
        this.value = value;
    }

    public Node(Object value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Удаляет узел
     * @return удаляемый узел
     */
    public Node remove() {
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
        return this;
    }
}

