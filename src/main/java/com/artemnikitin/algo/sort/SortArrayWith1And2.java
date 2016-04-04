package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class SortArrayWith1And2 {

    static int[] data = {1, 2, 2, 1, 2, 2, 1, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data));
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        int counter = 0;
        for (int element : data) {
            if (element == 1) counter++;
        }
        for (int i = 0; i < counter; i++) {
            data[i] = 1;
        }
        for (int i = counter; i < data.length; i++) {
            data[i] = 2;
        }
    }

}
