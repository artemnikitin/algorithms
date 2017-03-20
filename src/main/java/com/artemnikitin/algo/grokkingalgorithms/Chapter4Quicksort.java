package com.artemnikitin.algo.grokkingalgorithms;

import com.artemnikitin.algo.Data;
import com.artemnikitin.algo.grokkingalgorithms.common.Common;

import java.util.Arrays;

public class Chapter4Quicksort {

    public static void main(String[] args) {
        int[] unsorted = Data.UNSORTED_ARRAY;

        System.out.println(Arrays.toString(unsorted));
        quicksort(unsorted, 0, unsorted.length - 1);
        System.out.println(Arrays.toString(unsorted));
    }

    public static void quicksort(int[] array, int low, int high) {
        if (low <= high) {
            int min = low;
            int max = high;
            int pivot = low + (high - low) / 2;
            while (min <= max) {
                while (array[min] < array[pivot]) min++;
                while (array[max] > array[pivot]) max--;
                if (min <= max) {
                    Common.swap(array, min, max);
                    min++;
                    max--;
                }
            }
            quicksort(array, low, max);
            quicksort(array, min, high);
        }
    }

}
