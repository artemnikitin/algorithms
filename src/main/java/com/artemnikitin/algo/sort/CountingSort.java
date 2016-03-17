package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class CountingSort {

    static int[] data = Data.UNSORTED_ARRAY;
    static int[] data2 = Data.UNSORTED_ARRAY_2;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data));
        countingSort(data, 0, 35);
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(data2));
        countingSort(data2, -333, 39);
        System.out.println(Arrays.toString(data2));
    }

    public static void countingSort(int[] data, int min, int max){
        int[] count = new int[max - min + 1];
        for (int number : data) {
            count[number - min]++;
        }
        int z = 0;
        for (int i = min; i <= max; i++) {
            while (count[i - min] > 0){
                data[z] = i;
                z++;
                count[i - min]--;
            }
        }
    }

}