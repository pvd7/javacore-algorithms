package ru.javacore2.algorithm.lesson3.util;

/**
 * Приоритетная очередь
 * Состоит из n очередей, где n - количество допустимых приоритетов
 * Каждая очередь представляет из себя односвязный список, указывающи только на следующий элемент
 * Значения добавляются тольок в конец очереди, берутся из начала.
 */
public class PriorityQueue {

    // элемент очереди
    class EntityQueue {
        Object value; // значение
        EntityQueue next; // указатель на следующий элемент

        EntityQueue(Object value) {
            this.value = value;
        }
    }

    // количество приоритетов, определяет размер массивов конца и начала очередей
    private int lengthPriority = Priority.values().length;
    // массив начала очередей
    private EntityQueue[] headQueue = new EntityQueue[lengthPriority];
    // массив коца очередей
    private EntityQueue[] tailQueue = new EntityQueue[lengthPriority];
    // массив размеров очередей
    private int[] sizeQueue = new int[lengthPriority];

    public PriorityQueue() {
    }

    public void add(Object value, Priority priority) {
        int i = priority.ordinal();
        EntityQueue entity = new EntityQueue(value);
        if (sizeQueue[i] == 0) {
            tailQueue[i] = entity;
            headQueue[i] = tailQueue[i];
        } else {
            tailQueue[i].next = entity;
            tailQueue[i] = tailQueue[i].next;
        }
        sizeQueue[i]++;
    }

    public void add(Object value) {
        add(value, Priority.NORMAL);
    }

    private int getQueuePriority(){
        for (int i = lengthPriority - 1; i >= 0 ; i--)
            if (sizeQueue[i] > 0)
                return i;
       return -1;
    }

    public Object peek() {
        int i = getQueuePriority();
        return (i > -1 ? headQueue[i].value : null);
    }

//    public Object peek(Priority priority) {
//        int i = priority.ordinal();
//        return (sizeQueue[i] > 0 ? headQueue[i].value : null);
//    }

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

    public int length() {
        int length = 0;
        for (int i = 0; i < lengthPriority; i++) {
            length += sizeQueue[i];
        }
        return length;
    }

    public int lengthQueue() {
        int i = getQueuePriority();
        return (i > -1 ? sizeQueue[i] : 0);
    }

    public int lengthQueue(Priority priority) {
        return sizeQueue[priority.ordinal()];
    }

}

