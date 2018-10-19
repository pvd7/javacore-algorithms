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

        boolean hasLeftChild() {
            return left != null;
        }

        boolean hasRightChild() {
            return right != null;
        }

//        boolean hasLeftGrandChildren() {
//            return hasLeftChild() && left.hasChildren();
//        }

//        boolean hasRightGrandChildren() {
//            return hasRightChild() && right.hasChildren();
//        }

        /**
         * Проверяет балансировку узла
         * Считаем, что узел отбалансирован, если слева и справа есть потомки в первых двух поколениях
         *
         * @return
         */
        boolean isBalanced() {
            if (left == null && right == null) return true;
            if (left != null && right != null) return true;
            if (left == null && !right.hasChildren()) return true;
            if (right == null && !left.hasChildren()) return true;
            return false;
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

    public boolean isEmpty() {
        return root == null;
    }

    public int getMax() {
        if (isEmpty()) throw new RuntimeException("tree is empty!");
        if (!root.hasChildren()) return root.id;
        return getMax(root).id;
    }

    public int getMin() {
        if (isEmpty()) throw new RuntimeException("tree is empty!");
        if (!root.hasChildren()) return root.id;
        return getMin(root).id;
    }

    /**
     * Проверяет балансировку узла
     *
     * @param node узел в дереве
     * @return результат
     */
    private boolean isBalanced(Node node) {
        return (node == null) || (node.isBalanced() && isBalanced(node.left) && isBalanced(node.right));
    }

    /**
     * Проверяет балансировку дерева
     *
     * @return результат
     */
    public boolean isBalanced() {
        return (root != null) && isBalanced(root);
    }

}
