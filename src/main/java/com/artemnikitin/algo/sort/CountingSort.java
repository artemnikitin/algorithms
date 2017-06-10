package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class CountingSort {

    private static int[] data = Data.UNSORTED_ARRAY;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data));
        countingSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void countingSort(int[] data) {
        int min = data[0];
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) min = data[i];
            if (data[i] > max) max = data[i];
        }

        int[] temp = new int[max - min + 1];
        for (int i = 0; i < data.length; i++) {
            temp[data[i] - min]++;
        }

        int index = 0;
        for (int i = min; i <= max; i++) {
            while (temp[i - min] > 0) {
                data[index] = i;
                index++;
                temp[i - min]--;
            }
        }
    }

}
