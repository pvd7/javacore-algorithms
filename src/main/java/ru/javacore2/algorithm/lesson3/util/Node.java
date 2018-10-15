package ru.javacore2.algorithm.lesson3.util;

/**
 * Узел очереди
 */
public class Node {

    protected Object value; // значение
    Node prev; // указатель на предидущий узел
    Node next; // указатель на следующий узел

    public Node(Object value) {
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

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

