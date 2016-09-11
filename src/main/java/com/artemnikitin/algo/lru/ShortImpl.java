package com.artemnikitin.algo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShortImpl {

    public static void main(String[] args) {
        LRUCacheShort<String, String> lru = new LRUCacheShort<>(3);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.get("3");
        lru.get("2");
        lru.get("2");
        lru.get("1");
        lru.get("1");
        lru.put("4", "4");
        System.out.println("Size: " + lru.size());
        lru.forEach((k, v) -> System.out.println(k));
        lru.put("5", "5");
        System.out.println("Size: " + lru.size());
        lru.forEach((k, v) -> System.out.println(k));
    }

    public static class LRUCacheShort<K, V> extends LinkedHashMap<K, V> {
        private int cacheSize;

        public LRUCacheShort(int cacheSize) {
            super(16, 0.75f, true);
            this.cacheSize = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > cacheSize;
        }
    }

}
