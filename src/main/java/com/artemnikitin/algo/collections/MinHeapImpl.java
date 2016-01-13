package com.artemnikitin.algo.collections;

public class MinHeapImpl {

    public static void main(String[] args){
        MinHeap heap = new MinHeap();
        heap.add(1);
        heap.add(12);
        heap.add(3);
        heap.add(14);
        heap.add(11);

        while(heap.size() > 0){
            System.out.println("Heap size: " + heap.size());
            System.out.println(heap.remove());
        }
    }

}
