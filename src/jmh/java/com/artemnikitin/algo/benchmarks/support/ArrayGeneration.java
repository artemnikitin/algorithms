package com.artemnikitin.algo.benchmarks.support;

import java.util.Random;

public class ArrayGeneration {

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt();
        }
        return result;
    }

}
