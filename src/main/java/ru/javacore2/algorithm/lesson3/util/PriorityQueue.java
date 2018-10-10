package ru.javacore2.algorithm.lesson3.util;

/**
 * Приоритетная очередь
 * Состоит из n очередей, где n - количество допустимых приоритетов
 * Каждая очередь представляет из себя односвязный список, указывающи только на следующий элемент
 * Значения добавляются тольок в конец очереди, берутся из начала.
 */
public class PriorityQueue {

    // элемент очереди
    class Node {
        Object value; // значение
        Node next; // указатель на следующий элемент

        Node(Object value) {
            this.value = value;
        }
    }

    // количество приоритетов, определяет размер массивов конца и начала очередей
    private int lengthPriority = Priority.values().length;
    // массив начала очередей
    private Node[] headQueue = new Node[lengthPriority];
    // массив коца очередей
    private Node[] tailQueue = new Node[lengthPriority];
    // массив размеров очередей
    private int[] sizeQueue = new int[lengthPriority];

    public PriorityQueue() {
    }

    /**
     * Добавляет элемент в очередь
     *
     * @param value    значение
     * @param priority приоритет
     */
    public void add(Object value, Priority priority) {
        int i = priority.ordinal();
        Node entity = new Node(value);
        if (sizeQueue[i] == 0) {
            tailQueue[i] = entity;
            headQueue[i] = tailQueue[i];
        } else {
            tailQueue[i].next = entity;
            tailQueue[i] = tailQueue[i].next;
        }
        sizeQueue[i]++;
    }

    /**
     * Добавляет элемент в очередь
     * приоритет = Priority.NORMAL
     *
     * @param value значение
     */
    public void add(Object value) {
        add(value, Priority.NORMAL);
    }

    /**
     * Возваращет интекс из массива очередей, где есть элементы
     * просмотр приоритетов справа налево
     *
     * @return
     */
    private int getQueuePriority() {
        for (int i = lengthPriority - 1; i >= 0; i--)
            if (sizeQueue[i] > 0)
                return i;
        return -1;
    }

    /**
     * Возвращает элемент из начала очереди
     *
     * @return значение
     */
    public Object peek() {
        int i = getQueuePriority();
        return (i > -1 ? headQueue[i].value : null);
    }

//    public Object peek(Priority priority) {
//        int i = priority.ordinal();
//        return (sizeQueue[i] > 0 ? headQueue[i].value : null);
//    }

    /**
     * Удаляет элемент из начала очереди
     *
     * @return значение
     */
    public Object remove() {
        Object obj = null;
        int i = getQueuePriority();
        if (i > -1) {
            obj = headQueue[i].value;
            headQueue[i] = headQueue[i].next;
            sizeQueue[i]--;
        }
        return obj;
    }

    /**
     * Длина все очереди
     *
     * @return длина
     */
    public int length() {
        int length = 0;
        for (int i = 0; i < lengthPriority; i++) {
            length += sizeQueue[i];
        }
        return length;
    }

    /**
     * Количество элементов из массива очередей (в порядке убывания приоритета), где есть есть хоть один элемент
     * если нигдле нет элементов то вернет 0
     *
     * @return количество элементов
     */
    public int lengthQueue() {
        int i = getQueuePriority();
        return (i > -1 ? sizeQueue[i] : 0);
    }

    /**
     * Количество элементов в очереди с указанным приоритетом
     *
     * @param priority приоритет
     * @return количество
     */
    public int lengthQueue(Priority priority) {
        return sizeQueue[priority.ordinal()];
    }

}

