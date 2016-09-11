package com.artemnikitin.algo.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DefaultImpl {

    public static void main(String[] args) {
        LRUCacheDefault<String, String> lru = new LRUCacheDefault<>(3);
        lru.set("1", "1");
        lru.set("2", "2");
        lru.set("3", "3");
        lru.get("3");
        lru.get("2");
        lru.get("2");
        lru.get("1");
        lru.get("1");
        lru.set("4", "4");
        System.out.println("Size: " + lru.size());
        lru.printElements();
        lru.set("5", "5");
        System.out.println("Size: " + lru.size());
        lru.printElements();
    }

    public static class LRUCacheDefault<K, V> {
        private final int size;
        private final Map<K, V> map;
        private final List<Pair<K, V>> list;

        public LRUCacheDefault(int size) {
            this.size = size;
            map = new HashMap<>(size);
            list = new LinkedList<>();
        }

        public void set(K key, V value) {
            if (map.containsKey(key)) {
                list.remove(new Pair<>(key, value));
                list.add(0, new Pair<>(key, value));
            } else {
                if (list.size() >= size) {
                    Pair<K, V> item = list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                    map.remove(item.key);
                }
                map.put(key, value);
                list.add(0, new Pair<>(key, value));
            }
        }

        public V get(K key) {
            if (map.containsKey(key)) {
                list.remove(new Pair<>(key, map.get(key)));
                list.add(0, new Pair<>(key, map.get(key)));
            }
            return map.get(key);
        }

        public int size() {
            return map.size();
        }

        public void printElements() {
            map.forEach((k, v) -> System.out.println(k));
        }
    }

    public static class Pair<K, V> {
        final K key;
        final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!key.equals(pair.key)) return false;
            return value.equals(pair.value);

        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }
    }

}
