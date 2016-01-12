package com.artemnikitin.algo.search;

public class SentinelLinearSearch {

    static int[] data = { 0, 2, 5, 6, 7, 61, 122, 566 };

    public static void main(String... args){
       search(data, 122);
    }

    static void search(int[] data, int num){
        int last = data[data.length - 1];
        data[data.length - 1] = num;
        int i = 0;
        while (data[i] != num) {
            i++;
        }
        data[data.length - 1] = last;
        if (i < data.length - 1 || data[data.length - 1] == num) {
            System.out.println("Element " + data[i] +" found on position " + i);
        } else {
            System.out.println("Element not found.");
        }
    }



}
