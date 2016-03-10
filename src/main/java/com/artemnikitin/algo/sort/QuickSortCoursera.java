package com.artemnikitin.algo.sort;

import java.io.IOException;
import java.util.Arrays;

public class QuickSortCoursera {

    static int[] data = {20, 8, 7, 0, 15, 35, 11, 0};

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(data));
        quicksort(0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    private static void quicksort(int low, int high){
        if (high > low) {
            int i = low, j = high;
            int pivot = low + (high - low) / 2;
            while (i <= j) {
                while (data[i] < data[pivot]) i++;
                while (data[j] > data[pivot]) j--;
                if (i <= j) {
                    swap(i, j);
                    i++;
                    j--;
                }
            }
            quicksort(low, j);
            quicksort(i, high);
        }
    }

    private static void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
