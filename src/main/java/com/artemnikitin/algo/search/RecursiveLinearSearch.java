package com.artemnikitin.algo.search;

public class RecursiveLinearSearch {

    private static int[] data = {2, 5, 1, 7, 9, 3, 4, 55};

    public static void main(String[] args) {
        System.out.println(searchFor(0, 5));
        System.out.println(searchFor(0, 55));
        System.out.println(searchFor(0, 5555));
    }

    public static boolean searchFor(int position, int i) {
        if (position > data.length - 1) {
            return false;
        } else if (data[position] == i) {
            return true;
        } else {
            return searchFor(position + 1, i);
        }
    }

}
