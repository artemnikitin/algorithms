package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class RadixSort {

    static int[] data = {20, 8, 7, 0, 15, 35, 11, 0};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data));
        radixSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void radixSort(int[] data){
        int max = data[0], exp = 1;
        int[] temp = new int[data.length];

        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        while ((max / exp) > 0) {
            int[] bucket = new int[10];

            //Identify number of elements in each bucket
            for (int i = 0; i < data.length; i++) {
                bucket[data[i] / exp % 10]++;
            }

            // Create index for the calculation
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            // Insert array values into its respective bucket
            for (int i = data.length - 1; i >= 0; i--) {
                temp[--bucket[data[i] / exp % 10]] = data[i];
            }

            // Order original array based on buckets order
            for (int i = 0; i < data.length; i++) {
                data[i] = temp[i];
            }

            // Move to the next digit
            exp *= 10;
        }
    }

}
