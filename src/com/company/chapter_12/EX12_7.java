package com.company.chapter_12;

import com.company.BaseSolution;

/**
 * Gets a string from the user and prints it's contents reversed
 */
public class EX12_7 extends BaseSolution {

    public static void main(String[] args) {
        System.out.println("Enter word:");
        String word = getString();
        System.out.println("The word: " + word);
        // String reversed = reverseRecursively(word);
        String reversed = reverseRecursive(word);
        System.out.println("Reversed: " + reversed);

        close();
    }

    private static String reverseRecursive(String word) {
        int lastIndex = word.length() - 1;
        return reverseRecursive(word, lastIndex);
    }
    private static String reverseRecursive(String word, int lastIndex) {
        String reversed = "";
        if (lastIndex >= 0)
            reversed = word.charAt(lastIndex) + reverseRecursive(word, lastIndex - 1);
        return reversed;
    }



}
