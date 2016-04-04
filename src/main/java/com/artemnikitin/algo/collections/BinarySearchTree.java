package com.artemnikitin.algo.collections;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(Comparable obj) {
        Node node = new Node();
        node.data = obj;
        node.left = null;
        node.right = null;
        if (root == null) root = node;
        else root.addNode(node);
    }

    public boolean find(Comparable obj) {
        Node current = root;
        while (current != null) {
            int d = current.data.compareTo(obj);
            if (d == 0) return true;
            else if (d > 0) current = current.left;
            else current = current.right;
        }
        return false;
    }

    public void remove(Comparable obj) {
        Node toRemove = root;
        Node parent = null;
        boolean found = false;
        while (!found && toRemove != null) {
            int d = toRemove.data.compareTo(obj);
            if (d == 0) found = true;
            else {
                parent = toRemove;
                if (d > 0) toRemove = toRemove.left;
                else toRemove = toRemove.right;
            }
        }
        if (!found) return;

        if (toRemove.left == null || toRemove.right == null) {
            Node newChild;
            if (toRemove.left == null) newChild = toRemove.right;
            else newChild = toRemove.left;
            if (parent == null) root = newChild;
            else if (parent.left == toRemove) parent.left = newChild;
            else parent.right = newChild;
            return;
        }

        Node smallestParent = toRemove;
        Node smallest = toRemove.right;
        while (smallest.left != null) {
            smallestParent = smallest;
            smallest = smallest.left;
        }

        toRemove.data = smallest.data;
        smallestParent.left = smallest.right;
    }

    public void print() {
        if (root != null) root.printNodes();
        System.out.println();
    }

    private class Node {

        public Comparable data;
        public Node left;
        public Node right;

        public void addNode(Node node) {
            int comparison = node.data.compareTo(data);
            if (comparison < 0) {
                if (left == null) left = node;
                else left.addNode(node);
            } else {
                if (right == null) right = node;
                else right.addNode(node);
            }

        }

        public void printNodes() {
            if (left != null) left.printNodes();
            System.out.println(data + " ");
            if (right != null) right.printNodes();
        }
    }

}
