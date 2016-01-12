package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class MergeSortMyImpl {

    static int[] data = {20, 8, 7, 0, 15, 35, 11, 0};
    static int[] helper = new int[data.length];

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        mergeSort(0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int low, int high){
        if (high > low) {
            int pivot = low + (high - low) / 2;
            mergeSort(low, pivot);
            mergeSort(pivot + 1, high);
            mergeResults(low, pivot, high);
        }
    }

    private static void mergeResults(int low, int pivot, int high) {
        System.arraycopy(data, low, helper, low, high + 1 - low);
        int left_idx = low;
        int right_idx = pivot + 1;
        int counter = low;
        while (left_idx <= pivot && right_idx <= high) {
            if (helper[left_idx] <= helper[right_idx]) {
                data[counter] = helper[left_idx];
                left_idx++;
            } else {
                data[counter] = helper[right_idx];
                right_idx++;
            }
            counter++;
        }
        while (left_idx <= pivot) {
            data[counter] = helper[left_idx];
            counter++;
            left_idx++;
        }
        while (right_idx <= high) {
            data[counter] = helper[right_idx];
            counter++;
            right_idx++;
        }
    }

}
