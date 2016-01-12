package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class QuickSortMyImpl {

    static int[] data = {20, 0, 7, 1, 15, 35, 11, 0};

    public static void main(String[] args){
        System.out.println(Arrays.toString(data));
        quicksort(0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    private static void quicksort(int low, int high){
        if (high > low) {
            //System.out.println("=======");
            //System.out.println("Array to sort:");
            //for (int k = low; k <= high; k++) System.out.print(data[k] + " ");
            //System.out.println();
            int i = low, j = high;
            int pivot = low + (high - low) / 2;
            //System.out.println("Pivot = " + data[pivot]);
            while (i <= j) {
                while (data[i] < data[pivot]) i++;
                while (data[j] > data[pivot]) j--;
                if (i <= j) {
                    swap(i, j);
                    i++;
                    j--;
                }
            }
            //System.out.println("Sorted array:");
            //for (int k = low; k <= high; k++) System.out.print(data[k] + " ");
            //System.out.println();
            quicksort(i, high);
            quicksort(low, j);
        }
    }

    private static void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}