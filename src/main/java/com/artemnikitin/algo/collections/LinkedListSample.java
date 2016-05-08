package com.artemnikitin.algo.collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListSample {

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.addLast("John");
        names.addLast("Vanessa");
        names.addLast("Burberry");
        names.addLast("Zaira");

        ListIterator<String> iterator = names.listIterator();
        iterator.next();
        iterator.add("Sergey");

        System.out.println("Result:");
        for (String name : names) System.out.print(name + " ");
        System.out.println();
        System.out.println("Expected:");
        System.out.println("John Sergey Vanessa Burberry Zaira");
    }

}
