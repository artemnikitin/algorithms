package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class MergeSort {

    static int[] data = Data.UNSORTED_ARRAY;
    static int[] helper = Data.HELPER_ARRAY;

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
        int left = low;
        int right = pivot + 1;
        int counter = low;
        while (left <= pivot && right <= high) {
            if (helper[left] <= helper[right]) {
                data[counter] = helper[left];
                left++;
            } else {
                data[counter] = helper[right];
                right++;
            }
            counter++;
        }
        while (left <= pivot) {
            data[counter] = helper[left];
            counter++;
            left++;
        }
        while (right <= high) {
            data[counter] = helper[right];
            counter++;
            right++;
        }
    }

}
