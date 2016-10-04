package com.artemnikitin.algo.basic;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(101));
        System.out.println(isPrime(4));
        System.out.println(isPrimeOptimized(103));
        System.out.println(isPrimeOptimized(8));
        System.out.println(isPrimeEvenMoreOptimized(97));
        System.out.println(isPrimeEvenMoreOptimized(10));
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeOptimized(int n) {
        for (int i = 2; 2 * i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeEvenMoreOptimized(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
