package com.artemnikitin.algo.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortCoursera {

    static int[] data = {20, 8, 7, 0, 15, 35, 11, 0};
    static long counter = 0;
    static int first;
    static int last;

    public static void main(String[] args) throws IOException {
        data = getDataFromFile("/Users/artemnikitin/Downloads/10.txt");
        first = data[0];
        last = data[data.length - 1];
        System.out.println(Arrays.toString(data));
        quicksort(0, data.length - 1);
        System.out.println(Arrays.toString(data));
        System.out.println("Num of comparisons : " + counter);
    }

    private static void quicksort(int low, int high){
        //System.out.println("Array length : " + (high - low));
        //if(high - low > 0) counter += high - low;
        if (high > low) {
            counter += high - low;
            int i = low, j = high;
            int pivot = low + (high - low) / 2;
            while (i <= j) {
                while (data[i] < data[pivot]) i++;
                while (data[j] > data[pivot]) j--;
                if (i <= j) {
                    swap(i, j);
                    i++;
                    j--;
                }
            }
            quicksort(low, j);
            quicksort(i, high);
        }
    }

    private static void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static int[] getDataFromFile(String file) throws IOException {
        List<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while(line != null) {
            result.add(Integer.parseInt(line));
            line = br.readLine();
        }
        return returnArray(result);
    }

    private static int[] returnArray(List<Integer> result) {
        int[] array = new int[result.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = result.get(i);
        return array;
    }


}
