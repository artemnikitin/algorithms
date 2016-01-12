package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class SelectionSort {

    static int[] data = {20, 8, 0, 7, 15, 35, 11, 0};

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        for(int i = 0; i < data.length - 1; i++) sort(i);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int i){
        int pos = i;
        for(int j = i; j < data.length; j++){
            if(data[j] < data[pos]) pos = j;
        }
        swap(i, pos);
    }

    private static void swap(int first, int second){
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }


}
