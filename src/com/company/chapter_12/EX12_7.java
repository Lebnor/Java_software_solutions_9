package com.company.chapter_12;

import com.company.BaseSolution;

import java.util.Scanner;

public class EX12_7 extends BaseSolution {

    public static void main(String[] args) {
        System.out.println("Enter word:");
        String word = getString();
        System.out.println("The word: " + word);
        // String reversed = reverseRecursively(word);
        String reversed = reverseRecursive(word);
        System.out.println("Reversed: " + reversed);
    }

//    public static String reverseRecursively(String word) {
//        int lastIndex = word.length() - 1;
//        return reverseRecursively(word, "", lastIndex);
//    }
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

//    private static String reverseRecursively(String word, String curr, int index) {
//        if (index == 0) {
//            curr += word.charAt(index);
//            return curr;
//        } else {
//            curr += word.charAt(index);
//            return reverseRecursively(word, curr, index - 1);
//        }
//    }


}
