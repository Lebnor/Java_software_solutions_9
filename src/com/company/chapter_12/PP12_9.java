package com.company.chapter_12;

import java.util.Arrays;

/**
 * Implements binary search on array of strings using recursion
 */
public class PP12_9 {

    private final static int SIZE = 20;

    public static void main(String[] args) {
        String[] strings = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            strings[i] = ( "" + i );
        }
        System.out.println(Arrays.toString(strings));

        for (int i = 0; i < SIZE; i++) {
            printIfInArray(strings, "" + i);
        }

        //seperate
        System.out.println("\n\n\n");

        // test random numbers
        for (int i = 0; i < SIZE; i++) {
            int rand = (int) ( Math.random() * 100 );
            printIfInArray(strings, "" + rand);
        }


    }

    private static void printIfInArray(String[] list, String toCheck) {
        boolean valueInList = inList(list, toCheck);
        System.out.println( toCheck + " in the list: " + valueInList );
    }

    /**
     * checks if a string value is in an array of string objects
     * @param list the list of string objects
     * @param value the value to search for
     * @return true if the value is in the array, false otherwise
     */
    public static boolean inList(String[] list, String value) {
        int mid = ( list.length ) / 2;
        if ( list[mid].equals(value) )
            return true;
        return inLeftSide(0, mid, list, value) || inRightSide(mid + 1, SIZE - 1, list, value);
    }

    // searches left side of original array from start to end inclusive
    private static boolean inLeftSide(int start, int end, String[] list, String value) {
        if ( end <= start )
            return false;
        int mid = ( start + end ) / 2;
        if ( list[mid].equals(value) )
            return true;
        return inLeftSide(start, mid, list, value) || inRightSide(mid + 1, end, list, value);
    }
    // searches right side of the array from start to end inclusive
    private static boolean inRightSide(int start, int end, String[] list, String value) {
        if ( end < start )
            return false;
        int mid = ( start + end ) / 2;
        if ( list[mid].equals(value) )
            return true;
        return inLeftSide(start, mid, list, value) || inRightSide(mid + 1, end, list, value);
    }

}
