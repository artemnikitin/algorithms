package com.artemnikitin.algo.grokkingalgorithms;

import com.artemnikitin.algo.Data;

import java.util.Arrays;

public class Chapter4Recursion {

    public static void main(String[] args) {
        int[] sorted = Data.SORTED_ARRAY;
        Node<Integer> list = new Node<>(1, new Node<>(25, new Node<>(2, new Node<>(370, new Node<>(2, null)))));

        System.out.println(Arrays.toString(sorted));
        System.out.println(recursiveSum(sorted, 0, 0));
        System.out.println();

        System.out.println(list);
        System.out.println(sizeOfList(list, 0));
        System.out.println();

        System.out.println(list);
        System.out.println(maxInList(list, 0));
        System.out.println();

        System.out.println(Arrays.toString(sorted));
        System.out.println(recursiveBinarySearch(sorted, 0, sorted.length - 1, 8));
        System.out.println(recursiveBinarySearch(sorted, 0, sorted.length - 1, 9));
        System.out.println();
    }

    public static int recursiveSum(int[] array, int index, int sum) {
        if (array.length == 0) {
            return 0;
        } else if (index == array.length - 1) {
            return sum + array[index];
        } else {
            sum += array[index];
            return recursiveSum(array, index + 1, sum);
        }
    }

    public static int sizeOfList(Node<Integer> list, int length) {
        if (list.next == null) {
            return length + 1;
        } else {
            length++;
            return sizeOfList(list.next, length);
        }
    }

    public static int maxInList(Node<Integer> list, int max) {
        if (list.value > max) max = list.value;
        if (list.next == null) {
            return max;
        } else {
            return maxInList(list.next, max);
        }
    }

    public static int recursiveBinarySearch(int[] array, int low, int high, int element) {
        if (low <= high) {
            int pivot = low + (high - low) / 2;
            if (array[pivot] == element) {
                return pivot;
            } else if (array[pivot] < element) {
                recursiveBinarySearch(array, pivot + 1, high, element);
            } else {
                recursiveBinarySearch(array, low, pivot - 1, element);
            }
        }
        return -1;
    }

}
