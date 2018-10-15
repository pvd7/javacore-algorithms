package ru.javacore2.algorithm.lesson3.util;

import java.util.Iterator;

public class DequeIterator implements Iterator<Node> {

    private final Deque deque;
    private Node node;

    public DequeIterator(Deque deque) {
        this.deque = deque;
    }

    @Override
    public boolean hasNext() {
        return (node == null) ? (deque.getHead() != null) : (node.next != null);
    }

    @Override
    public Node next() {
        node = ((node == null) ? deque.getHead() : node.next);
        return node;
    }

    @Override
    public void remove() {
        if ((this.node == null) || (this.node == deque.getHead())) {
            deque.removeHead();
            this.node = deque.getHead();
        } else if (this.node == deque.getTail()) {
            deque.removeTail();
            this.node = deque.getTail();
        }
        else if (node != null) {
            Node node = this.node.next;
            this.node.remove();
            this.node = node;
        }
    }

    public void insert(Object value) {
        if ((this.node == null) || (this.node == deque.getHead()))
            this.node = deque.addHead(value);
        else {
            Node node = new Node(value);
            node.prev = this.node.prev;
            node.next = this.node;
            if (this.node.prev != null) this.node.prev.next = node;
            if (this.node.next != null) this.node.next.prev = node;
            this.node = node;
        }
    }

    @Override
    public String toString() {
        return deque.toString();
    }

    public Node getNode() {
        return node;
    }

    public Deque getDeque() {
        return deque;
    }
}
