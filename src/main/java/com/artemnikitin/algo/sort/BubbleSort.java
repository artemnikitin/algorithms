package com.artemnikitin.algo.sort;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class BubbleSort {

    static int[] data = Data.UNSORTED_ARRAY;

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j] < data[j - 1])
                    swap(j - 1, j);
            }
        }
    }

    private static void swap(int first, int second){
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

}
