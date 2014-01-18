package com.maffy.example.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by maryannfinnerty on 12/16/13.
 */
public class NumberPlay {

    /*
    Only works if array input does not contain zero
    and only one duplicate in the array of integers
     */
    public int findDup(int [] numbers) {

        int result = 0;
        for (int i : numbers) {
            result += i;
        }
        return result - ((numbers.length * (numbers.length -1))/2);
    }

    public int findDupWithZero(int [] numbers) {
        int result = 0;
        Set<Integer> seen = new HashSet<Integer>();
        for (int i : numbers) {
            if (seen.contains(i)) {
                result = i;
                break;
            }
            seen.add(i);
        }
        return result;
    }

    public int sumSquares(int [] input) {
        int result = 0;
        for (int i : input) {
            result += i * i;
        }
        return result;
    }

    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1))
            return number;
        else
            return fibonacci(number - 1) + fibonacci(number - 2);
    }
    /*
    Assumes that all numbers are duplicated except one - and returns that one
    int array cannot contain -1
     */
    public int findSingleAmidstDups(int [] input) {
        int result = -1;
        for (int i : input) {
           if (result == -1) {
               result = i;
           } else {
               result ^= i;
           }
        }

        return result;
    }

    public String findPairs(int [] numbers, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringBuilder builder = new StringBuilder();
        for (int i : numbers) {
                map.put(i, null);
        }

        for (int oneIndex = 0; oneIndex < numbers.length; oneIndex++) {
            int add = sum - numbers[oneIndex];
            if (map.containsKey(add)) {
                String input = String.format("%d+%d,", numbers[oneIndex], add);
                builder.append(input);
            }
        }
        String result = builder.toString();
        return result.substring(0,result.length() - 1);
    }

    public int findSingleAmidstDupsBruteForce(int [] input) {
        int result = -1;
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
        for (int i : input) {
            if (!seen.containsKey(i)) {
                seen.put(i, 1);
            } else {
                int temp = seen.get(i);
                seen.put(i, ++temp);
            }
        }
        for (int key : seen.keySet()) {
            if (seen.get(key) == 1) {
                result = key;
                break;
            }
        }
        return result;
    }
}
