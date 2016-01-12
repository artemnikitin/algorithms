package com.artemnikitin.algo.search;

public class BinarySearch {

    static int[] data = { 0, 2, 5, 6, 7, 61, 122, 566 };

    public static void main(String[] args){
        searchFor(0, data.length - 1, 61);
        searchFor(0, data.length - 1, 62);
        searchFor(0, data.length - 1, 566);
        searchFor(0, data.length - 1, 567);
        iterative(0, data.length - 1, 61);
        iterative(0, data.length - 1, 62);
        iterative(0, data.length - 1, 566);
        iterative(0, data.length - 1, 567);
    }

    private static void searchFor(int low, int high, int num){
        int pivot = low + (high - low) / 2 ;
        if(num == data[pivot]){
            System.out.println("Element found!");
       } 
        else if(num != data[pivot] && low >= high){
            System.out.println("Element not found!");
        }
        else if (num < data[pivot]){
            searchFor(low, --pivot, num);
        }
        else if (num > data[pivot]){
            searchFor(++pivot, high, num);
        }
    }

    private static void iterative(int low, int high, int num) {
        while(high >= low) {
            int pivot = low + (high - low) / 2;
            if (num == data[pivot]) {
                System.out.println("found");
                break;
            } else if (num < data[pivot]) {
                high = pivot - 1;
            } else if (num > data[pivot]){
                low = pivot + 1;
            }
        }
        System.out.println("not found");
    }

}
