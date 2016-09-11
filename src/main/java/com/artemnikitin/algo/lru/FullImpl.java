package com.artemnikitin.algo.lru;

import java.util.HashMap;
import java.util.Map;

public class FullImpl {

    public static void main(String[] args) {
        LRUCacheFull lru = new LRUCacheFull(3);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.get(3);
        lru.get(2);
        lru.get(2);
        lru.get(1);
        lru.get(1);
        lru.set(4, 4);
        System.out.println("SIZE: " + lru.map.size());
        lru.map.forEach((k, v) -> System.out.println(k));
        lru.set(5, 5);
        System.out.println("SIZE: " + lru.map.size());
        lru.map.forEach((k, v) -> System.out.println(k));
    }

    public static class LRUCacheFull {
        private final int capacity;
        Map<Integer, Node> map = new HashMap<>();
        Node head = null;
        Node end = null;

        public LRUCacheFull(int capacity) {
            this.capacity = capacity;
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                Node old = map.get(key);
                old.value = value;
                remove(old);
                setHead(old);
            } else {
                Node created = new Node(key, value);
                if (map.size() >= capacity) {
                    map.remove(end.key);
                    remove(end);
                    setHead(created);
                } else {
                    setHead(created);
                }
                map.put(key, created);
            }
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node n = map.get(key);
                remove(n);
                setHead(n);
                return n.value;
            }
            return -1;
        }

        private void remove(Node n) {
            if (n.prev != null) {
                n.prev.next = n.next;
            } else {
                head = n.next;
            }

            if (n.next != null) {
                n.next.prev = n.prev;
            } else {
                end = n.prev;
            }
        }

        private void setHead(Node n) {
            n.next = head;
            n.prev = null;

            if (head != null)
                head.prev = n;

            head = n;

            if (end == null)
                end = head;
        }

    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
