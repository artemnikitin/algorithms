package com.artemnikitin.algo.grokkingalgorithms;

import java.util.Arrays;

public class Chapter1 {

    public static void main(String[] args) {
        int[] sorted = new int[]{1, 3, 5, 7, 9, 12, 15, 17, 18};

        System.out.println(Arrays.toString(sorted));
        System.out.println(binarySearch(sorted, 8));
        System.out.println(binarySearch(sorted, 9));
    }

    public static int binarySearch(int[] array, int number) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int pivot = low + (high - low) / 2;
            if (array[pivot] == number) {
                return pivot;
            } else if (array[pivot] < number) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return -1;
    }

}
