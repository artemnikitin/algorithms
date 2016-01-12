package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class SelectionSortMyImpl {

    static int[] data = {11, 4, 7, 0, 2, 8, 0};

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data){
        for(int i = 0; i < data.length - 1; i++) {
            int cur = i;
            for(int j = cur; j < data.length; j++) {
                if(data[j] < data[cur]) {
                    cur = j;
                }
            }
            swap(cur, i);
        }
    }

    private static void swap(int first, int second){
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

}