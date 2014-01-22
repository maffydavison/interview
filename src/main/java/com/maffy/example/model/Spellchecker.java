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
                dictionary.put(line, 1);
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
        }
        return null;
    }

    private String stripDups(String inputString) {
        char found = '1';
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
            return builder.toString();
        } else {
            return null;
        }
    }


}
