package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class HeapSort {

    private static int[] data = Data.UNSORTED_ARRAY;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data));
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        int n = data.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--)
            fixHeap(data, i, n);
        while (n > 0) {
            swap(data, 0, n);
            n--;
            fixHeap(data, 0, n);
        }
    }

    private static void fixHeap(int[] data, int i, int n) {
        int root = data[i];
        boolean more = true;
        while (more) {
            int childIndex = getLeftChildIndex(i);
            if (childIndex <= n) {
                int rightChildIndex = getRightChildIndex(i);
                if (rightChildIndex <= n &&
                        data[rightChildIndex] > data[childIndex]) {
                    childIndex = rightChildIndex;
                }
                if (data[childIndex] > root) {
                    data[i] = data[childIndex];
                    i = childIndex;
                } else {
                    more = false;
                }
            } else {
                more = false;
            }
        }
        data[i] = root;
    }

    private static void swap(int[] data, int first, int second) {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    private static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

}
