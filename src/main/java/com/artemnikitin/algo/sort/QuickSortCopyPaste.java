package com.artemnikitin.algo.sort;

import java.util.Arrays;

public class QuickSortCopyPaste {

    private static int[] numbers = {20, 8, 7, 0, 15, 35, 11, 0};

    public static void main(String[] args){
        System.out.println(Arrays.toString(numbers));
        QuickSortCopyPaste algo = new QuickSortCopyPaste();
        algo.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            System.out.println("Please use actual array.");
        }
        quicksort(0, values.length - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];
        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }
            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we swap the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
