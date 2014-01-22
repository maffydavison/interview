package com.maffy.example.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maryanndavison on 1/20/14.
 */
public class Spellchecker {

    public static Map<String, Integer> dictionary = new HashMap<String, Integer>();

    private String vowels = "aeiouy";

    public Spellchecker(String inputFilename) {
        File inputFile = new File(inputFilename);
        try {
            BufferedReader in = new BufferedReader (new FileReader(inputFile));
            String line;
            while ((line = in.readLine()) != null) {
                dictionary.put(line.toLowerCase(), 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String correct(String inputString) {
        String result = null;
        String input = inputString.toLowerCase();
        if (dictionary.containsKey(input)) {
            result = input;
        }
        else {
            result = stripDups(input);
            if (result == null) {
                result = checkVowels(input);
            }
        }

        return result == null ? "No Suggestion" : result;
    }

    private String checkVowels(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            int index = vowels.indexOf(c);
            if (index != -1) {
                for (int i = 0; i < vowels.length() ; i++) {
                    if (vowels.charAt(i) != c) {
                        String temp = input.replaceFirst(String.valueOf(c), String.valueOf(vowels.charAt(i)));
                        if (dictionary.containsKey(temp)) {
                            return temp;
                        }
                    }
                }
            }
            count++;
        }
        return null;
    }

    private String stripDups(String inputString) {
        char found = '1';
        String result = null;
        StringBuilder builder = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (found == '1') {
                found = c;
                builder.append(c);
            } else {
                if (found != c) {
                    found = c;
                    builder.append(c);
                }
            }
        }
        if (dictionary.containsKey(builder.toString())) {
            result = builder.toString();
        } else {
            // last resort
            result = stripExtras(builder.toString());
        }

        return result;
    }

    private String stripExtras(String inputString) {
        String result = null;
        for (String s : dictionary.keySet()) {
            // examples provided seem to assume that the first letter is correct
            if (s.startsWith(String.valueOf(inputString.charAt(0)))) {
                boolean matched = true;
                for (int i = 0; i < s.length(); i++) {
                    if (!inputString.contains(String.valueOf(s.charAt(i)))) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    result = s;
                    break;
                }
            }
        }
        return result;
    }
}
