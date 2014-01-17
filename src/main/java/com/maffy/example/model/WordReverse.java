package com.maffy.example.model;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 11/10/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordReverse {

    public String reverse(String input) {
        String result = null;

        if (input != null && !input.isEmpty()) {
            String [] array = input.split(" ");
            if (array.length == 1) {
                result = input;
            } else {
                StringBuilder buffer = new StringBuilder();
                for (int i = array.length -1; i > 0; i--) {
                    buffer.append(array[i]).append(" ");
                }
                buffer.append(array[0]);
                result = buffer.toString();

            }
        }

        return result;
    }

    public String reverseString(String input) {
        String result = null;
        if (input != null && !input.isEmpty()) {
            StringBuilder buffer = new StringBuilder();
            char [] array = input.toCharArray();
            for (int i = array.length -1; i > 0; i--) {
                buffer.append(array[i]);
            }
            buffer.append(array[0]);
            result = buffer.toString();
        }

        return result;
    }
}
