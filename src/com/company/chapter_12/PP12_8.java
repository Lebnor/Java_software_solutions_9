package com.company.chapter_12;

import com.company.BaseSolution;

/**
 * asks user for a number and prints pascal's triangle up to that number
 */
public class PP12_8 extends BaseSolution {

    public static void main(String[] args) {
        System.out.println("Enter n-th line of pascal triangle: ");
        int line = getInt();
        printTriangle(line);

    }
    private static void printSpaces(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.print("   ");
        }
    }


    public static void printTriangle(int line) {
        for (int i = 0; i < line; i++) {
            int spaces = (line - i);
            printSpaces(spaces); // aline the row with spaces
            printNthLine(i);
            System.out.println();
        }


    }

    public static void printNthLine(int line) {
        int index = 1;
        printNthLine(line, index);
    }

    private static void printNthLine(int line, int index) {
        if (index > line) {
            System.out.print("1");
            return;
        }
        long element = findElement(line, index); // 1-based index
        System.out.print(element + "     ");
        printNthLine(line, index + 1);
    }

    private static long findElement(int line, int index) {
        // n! / (n−(x−1))!(x−1)!    n=line, x=index
        // formula from stackoverflow
        long nFactorial = factorial(line);
        long xFactorial = factorial(index - 1);
        return nFactorial / ( factorial(line - (index - 1) ) * xFactorial );
    }

    // calculate factorial of integer n
    private static long factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }
}
