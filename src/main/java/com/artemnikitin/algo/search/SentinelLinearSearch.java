package com.artemnikitin.algo.search;

public class SentinelLinearSearch {

    private static int[] data = {2, 5, 1, 7, 9, 3, 4, 55};

    public static void main(String... args){
        search(data, 5);
        search(data, 55);
        search(data, 122);
    }

    public static void search(int[] data, int num){
        int last = data[data.length - 1];
        data[data.length - 1] = num;
        int i = 0;
        while (data[i] != num) {
            i++;
        }
        data[data.length - 1] = last;
        if (i < data.length - 1 || data[data.length - 1] == num) {
            System.out.println("Element " + num +" found on position " + i);
        } else {
            System.out.println("Element " + num + " not found.");
        }
    }

}
