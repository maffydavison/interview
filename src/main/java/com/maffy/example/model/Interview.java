package com.maffy.example.model;

/**
 * Created by Maffy Davison on 12/17/13.
 */
public class Interview {

    public int findWordInString(String haystack, String needle) {
        int result = -1;
        int start = 0;
        char [] temp = new char[needle.length()];
        for (int i = 0; i< haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(start)) {
                result = i;
                temp[0] = needle.charAt(start);
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(++i) != needle.charAt(j)) {
                        temp = new char[needle.length()];
                    }
                    if (temp.length == 0) {
                        break;
                    } else {
                        temp[j] = needle.charAt(j);
                    }
                }
                if (temp.length != needle.length()) {
                    result = -1;
                }
            }
        }
        return result;
    }
}
