package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class InsertionSortMyImpl {

    static int[] data = {11, 4, 7, 0, 2, 8, 0};

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data) {
        for(int i = 1; i < data.length; i++) {
            int reference = data[i];
            int j = i - 1;
            while(j >= 0 && data[j] > reference) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = reference;
        }
    }

}
