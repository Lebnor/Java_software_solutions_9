package com.company.chapter_12;

import com.company.BaseSolution;

public class PP12_2 extends BaseSolution {
    public static void main(String[] args) {
        System.out.println("Enter 2 numbers:");
        int num1 = getInt();
        int num2 = getInt();

        int gcd = gcd(num1, num2);
        System.out.println("gcd: " + gcd);
    }

    public static int gcd(int num1, int num2) {
        if (num2 % num1 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }
}
