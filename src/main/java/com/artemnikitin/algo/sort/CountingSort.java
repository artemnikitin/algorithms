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
        int[] count = new int[max - min + 1];
        for (int number : data) {
            count[number - min]++;
        }
        int z = 0;
        for (int i = min; i <= max; i++) {
            while (count[i - min] > 0) {
                data[z] = i;
                z++;
                count[i - min]--;
            }
        }
    }

}
