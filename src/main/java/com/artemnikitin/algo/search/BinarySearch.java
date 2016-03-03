package com.artemnikitin.algo.search;

public class BinarySearch {

    static int[] data = { 0, 2, 5, 6, 7, 61, 122, 566 };

    public static void main(String[] args){
        recursive(data, 0, data.length - 1, 61);
        recursive(data, 0, data.length - 1, 62);
        recursive(data, 0, data.length - 1, 566);
        recursive(data, 0, data.length - 1, 567);
        iterative(data, 0, data.length - 1, 61);
        iterative(data, 0, data.length - 1, 62);
        iterative(data, 0, data.length - 1, 566);
        iterative(data, 0, data.length - 1, 567);
    }

    public static void recursive(int[] data, int low, int high, int num) {
        if (low > high) {
            System.out.println("Element not found!");
        } else {
            int pivot = low + (high - low) / 2 ;
            if(num == data[pivot]){
                System.out.println("Element found!");
            }
            else if (num < data[pivot]){
                recursive(data, low, --pivot, num);
            }
            else if (num > data[pivot]){
                recursive(data, ++pivot, high, num);
            }
        }
    }

    public static void iterative(int[] data, int low, int high, int num) {
        while(high >= low) {
            int pivot = low + (high - low) / 2;
            if (num == data[pivot]) {
                System.out.println("found");
                return;
            } else if (num < data[pivot]) {
                high = pivot - 1;
            } else if (num > data[pivot]){
                low = pivot + 1;
            }
        }
        System.out.println("not found");
    }

}
