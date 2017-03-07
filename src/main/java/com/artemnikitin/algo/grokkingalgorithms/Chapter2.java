package com.artemnikitin.algo.grokkingalgorithms;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class Chapter2 {

    public static void main(String[] args) {
        int[] unsorted = Data.UNSORTED_ARRAY;

        System.out.println(Arrays.toString(unsorted));
        selectionSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    public static void selectionSort(int[] array) {
        int smallestIndex;
        for (int i = 0; i < array.length - 1; i++) {
            smallestIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            swap(array, i, smallestIndex);
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
