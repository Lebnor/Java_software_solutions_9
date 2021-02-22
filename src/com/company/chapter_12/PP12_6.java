package com.company.chapter_12;

import java.util.Random;

/**
 * PP 12.6 In the language of an alien race, all words take the
 * form of Blurbs. A Blurb is a Whoozit followed by one or more
 * Whatzits. A Whoozit is the character ‘x’ followed by zero or
 * more ‘y’s. A Whatzit is a ‘q’ followed by either a ‘z’ or a ‘d’,
 * followed by a Whoozit. Design and implement a recursive
 * program that generates random Blurbs in this alien language.
 */
public class PP12_6 {

    private static final int MAX_LETTER = 10;

    public static void main(String[] args) {

        // TEST DRIVE
        String blurb = generateBlurb();
        System.out.println(blurb);
    }

    // return a Blurb
    public static String generateBlurb() {
        String whoozit = generateWhoozit();
        String whatzit = randomWhatzits();
        String endingWhoozit = generateWhoozit();
        return whoozit + whatzit + endingWhoozit;
    }

    // return a whatzit
    private static String generateWhatzit() {
        String whatzit = "q"; // starts with q
        whatzit += new Random().nextBoolean() ? "z" : "d"; // add either z or d
        return whatzit;
    }

    // return a whoozit
    private static String generateWhoozit() {
        String whoozit = "x"; // always starts with an x
        whoozit += randomY(); // zero or more y
        return whoozit;
    }

    // generate random amount of a string
    private static String randomY() {
        int max = (int) (Math.random() * MAX_LETTER);
        return randomY("y", max);
    }

    // helper method
    private static String randomY(String all, int max) {
        if (all.length() >= max)
            return all;
        return randomY( all + "y", max);
    }

    // generate a random amount of whatzit
    private static String randomWhatzits() {
        int random = (int) (Math.random() * MAX_LETTER);
        return randomWhatzits("", random);
    }
    // helper method
    private static String randomWhatzits(String all, int max) {
        if (all.length() > max)
            return all;
        return randomWhatzits(generateWhatzit() + all, max);
    }

}
