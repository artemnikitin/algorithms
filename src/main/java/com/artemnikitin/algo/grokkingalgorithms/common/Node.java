package com.artemnikitin.algo.grokkingalgorithms.common;

public class Node<E> {
    public final Node next;
    public final E value;

    public Node(E value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }

}
