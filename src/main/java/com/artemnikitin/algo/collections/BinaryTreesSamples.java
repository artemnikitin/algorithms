package com.artemnikitin.algo.collections;

public class BinaryTreesSamples {

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1);
        tree.add(5);
        tree.add(2);
        tree.add(10);
        tree.add(3);
        tree.print();
        System.out.println();

        tree.remove(7);
        tree.print();
        System.out.println();

        tree.remove(2);
        tree.print();
        System.out.println();

        System.out.println("Element found " + tree.find(10));
        System.out.println("Element not found " + tree.find(7));
    }

}
