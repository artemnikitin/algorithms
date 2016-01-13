package com.artemnikitin.algo.inversion;

import java.util.Arrays;

public class CountInversions {

    private static int[] data = {1, 5, 2, 4, 3, 6};
    private static int[] temp = new int[data.length];

    public static void main(String... args) {
        System.out.println(Arrays.toString(data));
        System.out.println("Number of inversions " + countUneffective());
        //System.out.println("Number of inversions " + countEffective(0, data.length));
    }

    public static int countUneffective() {
        int counter = 0;
        for(int i = 0; i < data.length - 1; i++) {
            for(int j = i + 1; j < data.length; j++)
                if(data[i] > data[j]) counter++;
        }
        return counter;
    }

    public static int countEffective(int start, int end) {
        int counter = 0;
        if(start == end) return counter;
        int pivot = end + (start - end) / 2;
        counter += countEffective(start, pivot);
        counter += countEffective(pivot + 1, end);
        counter += merge(start, pivot, end);
        return counter;
    }

    private static int merge(int start, int pivot, int end) {
        int counter = 0;
        int low = start, middle = pivot;
        while(low <= middle && middle <= end) {
            for (int i = 0; i < temp.length; i++) {
                if (data[low] <= data[middle]) {
                    low++;
                    data[i] = data[low];
                } else {
                    data[i] = data[middle];
                    counter++;
                    middle++;
                }
            }
        }
        return counter;
    }

}
