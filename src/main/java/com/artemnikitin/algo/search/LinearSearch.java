package com.artemnikitin.algo.search;

public class LinearSearch {

    private static int[] array = {2, 5, 1, 7, 9, 3, 4, 55};

    public static void main(String[] args) {
        searchFor(array, 1);
        searchFor(array, 11);
    }

    public static void searchFor(int[] array, int i) {
        for (int j = 0; j < array.length; j++) {
            if (array[j] == i) {
                System.out.println("Element " + i + " was found on position " + j);
                return;
            }
        }
        System.out.println("Element " + i + " wasn't found!");
    }

}
