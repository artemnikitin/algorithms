package com.artemnikitin.algo.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;

    public LinkedList() {
        first = null;
    }

    public Object getFirst() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public void addFirst(Object element) {
        Node node = new Node();
        node.data = element;
        node.next = first;
        first = node;
    }

    public Object removeFirst() {
        if (first == null) throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        return element;
    }

    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    private class Node {
        public Object data;
        public Node next;
    }

    private class LinkedListIterator implements ListIterator {

        private Node position;
        private Node previous;

        public LinkedListIterator() {
            position = null;
            previous = null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            if (!hasNext()) throw new NoSuchElementException();
            previous = position;
            if (position == null) position = first;
            else position = position.next;
            return position.data;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            return new Object();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
            if (previous.equals(position)) throw new IllegalStateException();
            if (position.equals(first)) removeFirst();
            else previous.next = position.next;
            position = previous;
        }

        @Override
        public void set(Object o) {
            //TODO
        }

        @Override
        public void add(Object o) {

        }

    }

}
