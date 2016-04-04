package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.io.IOException;
import java.util.Arrays;

public class QuickSort {

    static int[] data = Data.UNSORTED_ARRAY;

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(data));
        quicksort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    private static void quicksort(int[] data, int low, int high) {
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
            quicksort(data, low, j);
            quicksort(data, i, high);
        }
    }

    private static void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
