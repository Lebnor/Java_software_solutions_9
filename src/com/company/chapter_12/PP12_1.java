package com.company.chapter_12;

import com.company.BaseSolution;

public class PP12_1 extends BaseSolution {
    public static void main(String[] args) {
        System.out.println("Enter a word:");
        String word = getString();
        boolean isPalindrome = isPalindrome(word);
        System.out.println(word + " is palindrome: " + isPalindrome);
    }


    public static boolean isPalindrome(String word) {
        int index1 = 0;
        int index2 = word.length() - 1;
        if (word.length() <= 1)
            return true;
        if (word.charAt(index1) == word.charAt(index2)) {
            String substring = word.substring(index1 + 1, index2);
            return isPalindrome(substring);
        }
        return false;
    }
}
