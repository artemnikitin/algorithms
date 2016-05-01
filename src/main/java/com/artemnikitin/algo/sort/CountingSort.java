package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class CountingSort {

    private static int[] data = Data.UNSORTED_ARRAY;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data));
        countingSort(data, -3, 35);
        System.out.println(Arrays.toString(data));
    }

    public static void countingSort(int[] data, int min, int max) {
        // create and fill temp array
        int[] count = new int[max - min + 1];
        for (int i = 0; i < data.length; i++) {
            count[i - min]++;
        }
        int z = 0;
        // in for loop process temp array
        for (int i = min; i <= max; i++) {
            // if element > 0, then process it
            while (count[i - min] > 0) {
                data[z] = i;
                z++;
                count[i - min]--;
            }
        }
    }

}
