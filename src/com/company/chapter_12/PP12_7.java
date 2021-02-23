package com.company.chapter_12;

import com.company.BaseSolution;

/**
 * Design and implement a recursive program to
 * determine whether a string is a valid Blurb as defined in PP
 * 12.6.
 * A Blurb is a Whoozit followed by one or more
 * Whatzits.
 * A Whoozit is the character ‘x’ followed by zero or
 * more ‘y’s.
 * A Whatzit is a ‘q’ followed by either a ‘z’ or a ‘d’,
 * followed by a Whoozit.
 */
public class PP12_7 {

    public static void main(String[] args) {
        System.out.println("Enter a string:");
        String string = BaseSolution.getString();
//        boolean isBlurb = isBlurb(string);
//        System.out.printf("is %s a Blurb: %b", string, isBlurb);


        System.out.println(isBlurb(string));

        BaseSolution.close();
    }

    private static boolean isBlurb(String string) {
        if (string.isEmpty())
            return false;
        // get index where the starting whoozit ends
        int whoozitIndex = prefixWhoozit(string);

        // the rest of the string should be whatzits only
        String withoutWhoozit = string.substring(whoozitIndex);
        boolean oneOrMoreWhatzits = checkWhatzits(withoutWhoozit);
        return true;
    }

    // returns true if the string is one or more whatzits
    private static boolean checkWhatzits(String string) {
        if (string.length() < 3) { // after qz or qd there is a whoozit so at least 3 characters
            return false;
        }
        // must start with either qd or qz
        if ( string.startsWith("qd") || string.startsWith("qz") ) {

            String rest = string.substring(2); // remove beginning of whatzit
            int afterWhoozit = prefixWhoozit(rest); // there should be a whoozit now
            if (afterWhoozit == string.length()) { // the whoozit was the end of the string
                return true;
            } else {
                // there may more whatzits following
                return checkWhatzits(string.substring(afterWhoozit));
            }

        } else { // does not start as a whatzit
            return false;
        }
    }

    // returns the next index after the first whoozit in the given string
    private static int prefixWhoozit(String string) {
        if (string.startsWith("x")) {

            // there may be zero or more y's
            int i = 1;
            while ( i < string.length() && string.charAt(i) == 'y') { // advance until end or no more y's
                i++;
            }
            return i;

        } else { // does not start as a whoozit
            return -1;
        }
    }

}
