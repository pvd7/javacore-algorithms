package ru.javacore2.algorithm.lesson6.util;

public class Tree {

    class Node {
        int id;
        Node left;
        Node right;

        Node(int id) {
            this.id = id;
        }

        boolean hasChildren() {
            return left != null || right != null;
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
        Node node = start;
        while (true) {
            if (node.left == null) return node;
            node = node.left;
        }
    }

    private Node getMax(Node start) {
        if (start == null) throw new RuntimeException("start is null!");
        Node node = start;
        while (true) {
            if (node.right == null) return node;
                node = node.right;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getMax() {
        if (isEmpty()) throw new RuntimeException("tree is empty!");
        return getMax(root).id;
    }

    public int getMin() {
        if (isEmpty()) throw new RuntimeException("tree is empty!");
        return getMin(root).id;
    }

    /**
     * Проверяет балансировку узла
     *
     * @param node узел в дереве
     * @return -1 дерево не сбалансировано, иначе вернет глубину дерева
     */
    private int isBalanced(Node node) {
        if (node == null) return 0;

        int left = isBalanced(node.left);
        if (left == -1) return -1;

        int right = isBalanced(node.right);
        if (right == -1) return -1;

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

    /**
     * Проверяет балансировку дерева
     *
     * @return результат
     */
    public boolean isBalanced() {
        return (root != null) && (isBalanced(root) != -1);
    }

    /**
     * Подсчитывает глубину поддерева
     *
     * @param node начальный узел поддерева
     * @return глубина
     */
    private int depth(Node node) {
        return (node == null) ? 0 : Math.max(depth(node.left), depth(node.right)) + 1;
    }

    /**
     * Подсчитывает глубину дерева
     *
     * @return глубина
     */
    public int depth() {
        return depth(root);
    }

}
