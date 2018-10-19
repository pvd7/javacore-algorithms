package ru.javacore2.algorithm.lesson6.util;

import javax.swing.tree.TreeNode;

public class Tree {

    class Node {
        int id;
        Node left;
        Node right;

        Node(int id) {
            this.id = id;
        }
    }

    private Node root;

    public void insert(int id) {
        Node node = new Node(id);
        if (root == null)
            root = node;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;

                if (id < current.id) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (id > current.id) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else
                    return;
            }
        }
    }
    public boolean find(int id) {
        Node current = root;
        while (current.id != id) {
            current = (id < current.id) ? current.left : current.right;
            if (current == null) return false;
        }
        return true;
    }

    public void displayTree() {
        inOrderTravers(root);
    }

    private void inOrderTravers(Node node) {
        if (node != null) {
            inOrderTravers(node.left);
            System.out.println(node);
            inOrderTravers(node.right);
        }
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.id != id) {
            parent = current;
            if (id < current.id) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        // if a leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }

        // if has one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // if two ancestors
        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    private Node getSuccessor(Node node) {
        Node parent = node;
        Node s = node;
        Node current = node.right;

        while (current != null) {
            parent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

    private Node getMin(Node start) {
        if (start == null) throw new RuntimeException("start is null!");
        while (true) {
            if (start.left == null) {
                return start;
            } else {
                start = start.left;
            }
        }
    }

    private Node getMax(Node start) {
        if (start == null) throw new RuntimeException("start is null!");
        while (true) {
            if (start.right == null) {
                return start;
            } else {
                start = start.right;
            }
        }
    }

}
