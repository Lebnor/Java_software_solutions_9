package com.company;

import java.util.Scanner;

/**
 * Utility methods to receive input from user
 */
public class BaseSolution {

    private static Scanner scanner = new Scanner(System.in);



    public static String getString() {
        return scanner.nextLine();
    }

    public static int getInt() {
        return scanner.nextInt();
    }
}
