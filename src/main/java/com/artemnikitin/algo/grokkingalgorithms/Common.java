package com.artemnikitin.algo.grokkingalgorithms;

public class Common {

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
