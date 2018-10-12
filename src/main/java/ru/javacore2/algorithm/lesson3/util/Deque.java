package ru.javacore2.algorithm.lesson3.util;

import java.util.Iterator;

/**
 * Двухсторонняя очередь
 */
public class Deque implements Iterable<Node> {

    // голова - первый элемент в списке
    private Node head = null;
    // хвост - последний элемент в списке
    private Node tail = null;

    public Deque() {
    }

    public Deque(int... args) {
        for (int arg : args) addTail((arg));
    }

    /**
     * Добавляет элемент в конец очереди
     *
     * @param value значени
     */
    public void addTail(Object value) {
        if (isEmpty()) {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value, tail, null);
            tail = tail.next;
        }
    }

    /**
     * Добавляет элемент в начало очереди
     *
     * @param value значени
     */
    public Node addHead(Object value) {
        if (isEmpty()) {
            head = new Node(value);
            tail = head;
        } else {
            head.prev = new Node(value, null, head);
            head = head.prev;
        }
        return head;
    }

    /**
     * Удаляет элемент с конца очереди
     *
     * @return значение удаленного элемента
     */
    public Object removeTail() {
        if (isEmpty()) return null;
        Node node = tail;
        tail = tail.remove().prev;
        return node.value;
    }

    /**
     * Показывает элемент из конца очереди
     *
     * @return значение
     */
    public Object peekTail() {
        if (isEmpty()) return null;
        return tail.value;
    }

    /**
     * Удаляет элемент с начала очереди
     *
     * @return значение удаленного элемента
     */
    public Object removeHead() {
        if (isEmpty()) return null;
        Node node = head;
        head = head.remove().next;
        return node.value;
    }

    /**
     * Показывает элемент из начала очереди
     *
     * @return значение
     */
    public Object peekHead() {
        if (isEmpty()) return null;
        return head.value;
    }

    /**
     * Проверяет наличие элементов в очереди
     *
     * @return значение
     */

    public boolean isEmpty() {
        return (head == null) && (tail == null);
    }

    /**
     * Очищает очередь
     */
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node node = head;
        while (node != null) {
            str.append(node.value);
            if (node.next != null)
                str.append(", ");
            node = node.next;
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public Iterator iterator() {
        return new DequeIterator(this);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

}
