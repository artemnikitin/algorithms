package com.artemnikitin.algo.recursion;

public class Factorial {

    public static void main(String[] args) throws Exception {
        System.out.println(factorial(0));
        System.out.println(factorial(3));
    }

    public static int factorial(int n) throws Exception {
        if (n < 0) {
            throw new Exception("n should be >= 0");
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
