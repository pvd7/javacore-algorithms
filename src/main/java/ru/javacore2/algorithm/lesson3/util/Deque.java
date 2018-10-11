package ru.javacore2.algorithm.lesson3.util;

/**
 * Двухсторонняя очередь
 */
public class Deque {

    // узел очереди
    class Node {
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

        public Node remove() {
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
            return this;
        }
    }

    private int size = 0;
    private Node head = null;
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
        size++;
    }

    /**
     * Добавляет элемент в начало очереди
     *
     * @param value значени
     */
    public void addHead(Object value) {
        if (isEmpty()) {
            head = new Node(value);
            tail = head;
        } else {
            head.prev = new Node(value, null, head);
            head = head.prev;
        }
        size++;
    }

    /**
     * Удаляет элемент с конца очереди
     *
     * @return значение удаленного элемента
     */
    public Object removeTail() {
        if (isEmpty()) return null;
        size--;
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
        size--;
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
        return size == 0;
    }

    /**
     * Очищает очередь
     */
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Возвращате количество элементов в очереди
     *
     * @return количество
     */
    public int length() {
        return size;
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
}
