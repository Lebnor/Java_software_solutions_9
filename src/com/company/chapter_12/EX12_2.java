package com.company.chapter_12;

import java.util.Scanner;

/*
    Demonstrates definition of x to the power of y recursively
 */
public class EX12_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter x:");
        int x = scan.nextInt();
        System.out.println("Enter y > 0:");
        int y = scan.nextInt();
        while (y <= 0) {
            System.out.println("Enter y > 0:");
            y = scan.nextInt();
        }

        int result = power(x, y);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("Result of x^y (x to the power of y):");
        System.out.println("\t" + x + "^" + y + " = " + result);
    }

    /**
     * Calculates x to the power of y
     * @param x whole number
     * @param y positive integer
     * @return result of x to the power of y
     */
    public static int power(int x, int y) {
        if (y == 1)
            return x;
        return x * power(x, y - 1);
    }
}
