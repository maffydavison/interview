package com.maffy.example.model;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/24/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordPlay {

    public boolean isPalindrome(String input) {
        boolean result = true;

        String test = input.replaceAll("[ ,.;!]", "").toLowerCase();
        for (int i = 0, j= test.length() -1; i != j; i++, j--) {
            if (test.charAt(i) != test.charAt(j)) {
                result = false;
                break;
            }
        }

        return result;
    }

    public List<String> insertWordIntoSortedList(List<String> input, String word) {
        List<String> result = new ArrayList<String>();
        int index = 0;
        boolean done = false;
        for (String s : input) {
            if (done || s.charAt(index) < word.charAt(index)) {
                result.add(s);
            } else
            if (s.charAt(index) == word.charAt(index) && !done) {
                index++;
                while (index < s.length() && !done) {
                    if (index < word.length()) {
                        if (s.charAt(index) > word.charAt(index)) {
                            result.add(word);
                            result.add(s);
                            done = true;
                            index = 0;
                        } else if (s.charAt(index) < word.charAt(index)){
                            result.add(s);
                            result.add(word);
                            done = true;
                            index = 0;
                        } else {
                            index++;
                        }
                    } else {
                        result.add(s);
                        result.add(word);
                        done = true;
                        index = 0;
                    }
                }
            } else
            if (s.charAt(index) > word.charAt(index) && !done) {
                result.add(word);
                result.add(s);
                done = true;
                index = 0;
            }
        }

        return result;
    }

    public int [] mergeSortedArrays(int [] one, int [] two) {

        int total = one.length + two.length;
        int oneIndex = 0, twoIndex = 0;

        int [] result = new int[total];
        int count = 0;
        while (oneIndex < one.length && twoIndex < two.length) {
            if (one[oneIndex] < two[twoIndex]) {
                result[count++] = one[oneIndex++];
            } else {
                result[count++] = two[twoIndex++];
            }
        }

        while (oneIndex < one.length) {
            result[count++] = one[oneIndex++];
        }

        while (twoIndex < two.length) {
            result[count++] = two[twoIndex++];
        }

        return result;
    }

    public static String addStringToInt(String number, int addend) {

        char [] from = number.toCharArray();
        char [] to = String.valueOf(addend).toCharArray();
        int sum;
        int carry = 0;
        int shorter = from.length > to.length ? to.length - 1 : from.length -1;
        int longer = from.length > to.length ? from.length - 1 : to.length -1;
        StringBuilder builder = new StringBuilder();

        while (longer >= 0) {
            if (shorter >= 0 ) {
                sum = Character.getNumericValue(from[longer]) + Character.getNumericValue(to[shorter]) + carry;
            } else {
                sum = Character.getNumericValue(from[longer]) + carry;
            }
            if(sum > 9) {
                carry = 1;
                builder.append(sum % 10);
            } else {
                carry = 0;
                builder.append(sum);
            }

            longer--;
            shorter--;
        }


        return builder.reverse().toString();
    }

    public ListNode reverse(ListNode node) {
        ListNode result;
        ListNode secondElement;
        if (node == null || node.next == null) {
            result = node;
        } else {
            secondElement = node.next;
            node.next = null;
            ListNode reversed = reverse(secondElement);
            secondElement.next = node;
            result = reversed;
        }
        return result;
    }


}

