package com.maffy.example.model;

import java.util.*;

/**
 * Created by maryannfinnerty on 12/3/13.
 */
public class WordUnique {

    /*
    Given a String [] and a char []
    gather the words whose chars are ALL in the char []
    then return the longest words that match the chars provided in the char[]

    Example:  String [] x = { "a", "ab", "abc", "cba", "ba" }
              char [] y = { 'a', 'b' }

              would return: [ "ab", "ba" ]
     */

    public List getValidWords(String [] words, char [] chars) {

        List<String> wordList = new ArrayList<String>();

        for (String word : words) {
            boolean matched = true;
            for (int i = 0; i < chars.length; i++) {
                if (!word.contains(String.valueOf(chars[i]))) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                wordList.add(word);
            }
        }

        return getLongestWords(wordList);

    }

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

    public String getLongestWord(List<String> words) {
        List<String> result = new ArrayList<String>();
        int longest = 0;
        for (String word : words) {
            if (word.length() > longest) {
                longest = word.length();
                result.clear();
                result.add(word);
            }
        }

        return result.isEmpty() ? "nothing found" : result.get(0);
    }

    public List<String> getLongestWords(List<String> words) {
        List<String> result = new ArrayList<String>();
        int longest = 0;
        for (String word : words) {
            if (word.length() > longest) {
                longest = word.length();
            }
        }

        for (String word : words) {
            if (word.length() == longest) {
                result.add(word);
            }
        }

        return result;
    }
    /*
    Given an array of chars, return the first unique one

    Example:    char [] group = { 'a', 'b', 'a', 'c' }
                would return: b
     */

    public char findFirstUnique(char [] chars) {

        char result = '0';
        for (int i = 0; i < chars.length; i++) {
            result = chars[i];
            boolean found = true;
            for (int j = 0; j < chars.length; j++) {
                if (i != j) {
                    if (result == chars[j]) {
                        found = false;
                    }
                }
            }
            if (found) {
                break;
            }

        }
        return result;
    }

    /*
    function taking two strings - respond with a string that has each letter that is found in BOTH words, and
    each character in the response should appear the maximum number of times that that character appears
    in BOTH strings

    example:

        baac
        cbbc

        result:  bc

        bbbaac
        ddddcbba

        result:  bba
     */

    public String getRepeatedChars(String one, String two) {
        Map<Character, Integer> charFrequency;
        StringBuilder builder = new StringBuilder();
        String longer;
        if (one.length() > two.length()) {
            charFrequency = makeCharFrequencyMap(two);
            longer = one;
        } else {
            charFrequency = makeCharFrequencyMap(one);
            longer = two;
        }
        boolean done = false;
        String values = keysToString(charFrequency.keySet());
        for (int i = 0; i < values.length() ; i++) {
            if (charFrequency.isEmpty()) {
                done = true;
            } else {
                int frequency = charFrequency.get(values.charAt(i));
                int index = longer.indexOf(values.charAt(i));
                if (index != -1 && frequency > 0) {
                    builder.append(values.charAt(i));
                    charFrequency.put(values.charAt(i), --frequency);
                    while (frequency > 0 && !done) {
                        frequency = charFrequency.get(values.charAt(i));
                        index = longer.indexOf(values.charAt(i), ++index);
                        if (index == -1 || frequency < 1) {
                            done = true;
                        } else {
                            charFrequency.put(values.charAt(i), --frequency);
                            builder.append(values.charAt(i));
                        }
                    }

                }

                charFrequency.remove(values.charAt(i));

            }
        }

        return builder.toString();
    }

    private Map<Character, Integer> makeCharFrequencyMap(String one) {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (char c : one.toCharArray()) {
            if (result.containsKey(c)) {
                int temp = result.get(c);
                result.put(c, ++temp);
            } else {
                result.put(c, 1);
            }
        }
        return result;
    }
    private String keysToString(Set<Character> keys) {
        String result = "";
        for (char c : keys) {
            result += c;
        }
        return result;

    }

    public static void main(String[] args) {

        WordUnique wordUnique = new WordUnique();
        String result = wordUnique.getRepeatedChars("acca", "cbbba");

    }
}
