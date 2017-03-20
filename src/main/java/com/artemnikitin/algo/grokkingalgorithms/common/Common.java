package com.artemnikitin.algo.grokkingalgorithms.common;

public class Common {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
