package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class MergeSortCopyPaste {

    private static int[] data = {20, 0, 7, 1, 15, 35, 11, 0};
    private int[] numbers;
    private int[] helper;

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        MergeSortCopyPaste algo = new MergeSortCopyPaste();
        algo.sort(data);
        System.out.println(Arrays.toString(data));
    }

    public void sort(int[] values) {
        this.numbers = values;
        this.helper = new int[values.length];
        mergesort(0, values.length - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            System.out.println("==========");
            System.out.println("Middle = " + data[middle]);
            System.out.println("Input array: ");
            for (int k = low; k <= high; k++) System.out.print(data[k] + " ");
            System.out.println();
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }

}
