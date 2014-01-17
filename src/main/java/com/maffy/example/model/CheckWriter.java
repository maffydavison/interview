package com.maffy.example.model;

/**
 * Created by Maffy Davison on 1/5/14.
 */
public class CheckWriter {

    private static final String[] NUMBER = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String translate(int value) {
        String result = "";

        if (value < 20) {
            result += NUMBER[value];
        } else if (value >= 20 && value <100) {
            result += TENS[value / 10];
            if (value % 10 > 0) {
                result += " " + translate(value % 10);
            }
        } else if (value >= 100 && value < 1000) {
            result += translate(value / 100) + " hundred";
            if (value %100 > 0){
                result += " " + translate(value % 100);
            }
        } else if (value >= 1000 && value < 1000000) {
            result += translate(value / 1000) + " thousand";
            if (value % 1000 > 0) {
                result += " " + translate(value % 1000);
            }
        } else if (value >= 1000000) {
            result += translate(value / 1000000) + " million";
            if (value % 1000000 > 0) {
                result += " " + translate(value % 1000000);
            }
        } else if (value >= 1000000000) {
            result += translate(value / 1000000000) + " billion";
            if (value % 1000000000 > 0) {
                result += " " + translate(value % 1000000000);
            }
        }

        return result;
    }

}
