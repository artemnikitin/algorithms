package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class HeapSort {

    static int[] data = {20, 8, 7, 0, 15, 35, 11, 0};

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        sort();
        System.out.println(Arrays.toString(data));
    }

    private static void sort(){
        int n = data.length - 1;
        for(int i = (n - 1) / 2; i >= 0; i--)
            fixHeap(i, n);
        while(n > 0){
            swap(0, n);
            n--;
            fixHeap(0, n);
        }
    }

    private static void fixHeap(int i, int n) {
        int root = data[i];
        int index = i;
        int lastIndex = n;
        boolean more = true;
        while(more){
            int childIndex = getLeftChildIndex(index);
            if(childIndex <= lastIndex){
                int rightChildIndex = getRightChildIndex(index);
                if(rightChildIndex <= lastIndex &&
                   data[rightChildIndex] > data[childIndex]){
                        childIndex = rightChildIndex;
                }
                if(data[childIndex] > root){
                    data[index] = data[childIndex];
                    index = childIndex;
                } else {
                    more = false;
                }
            } else {
                more = false;
            }
        }
        data[index] = root;
    }

    private static void swap(int first, int second){
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    private static int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    private static int getRightChildIndex(int index){
        return 2 * index + 2;
    }

}
