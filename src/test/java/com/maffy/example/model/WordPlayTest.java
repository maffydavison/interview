package com.maffy.example.model;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maryanndavison on 1/16/14.
 */
public class WordPlayTest {

    WordPlay service;

    @Before
    public void setUp() throws Exception {
        service = new WordPlay();
    }

    @Test
    public void testMergeSortedArrays() throws Exception {

        int [] one = {1, 5, 7, 9};
        int [] two = {3, 6, 12, 15, 19, 34};

        int [] result = service.mergeSortedArrays(one, two);

        assert result.length == (one.length + two.length);
        assert result[0] == 1;
        assert result[1] == 3;
        assert result[2] == 5;

    }

    @Test
    public void testAddStringToInt() throws Exception {
        String one = "1234567";
        int two = 456;

        String result = WordPlay.addStringToInt(one, two);
        assert result != null;
        Assert.assertEquals("1235023", result);

    }

    @Test
    public void testIsPalindrome() throws Exception {
        String one = "A man, a plan, a canal, Panama!";
        boolean result = service.isPalindrome(one);
        assert result;
    }

    @Test
    public void testReverseList() throws Exception {
        ListNode one = new ListNode();
        ListNode two = new ListNode();
        ListNode three = new ListNode();
        one.setData("ONE");
        one.setNext(two);
        two.setData("TWO");
        two.setNext(three);
        three.setData("THREE");
        three.setNext(null);

        ListNode resultNode = service.reverse(one);
        assert resultNode.getData().equalsIgnoreCase("THREE");
    }

    @Test
    public void testInsertWordIntoSortedList() throws Exception {
        List<String> input = new ArrayList<String>();
        input.add("apple");
        input.add("bowwow");
        input.add("cow");
        input.add("dolphin");
        input.add("door");
        input.add("friend");

        String word = "dog";

        List<String> result = service.insertWordIntoSortedList(input, word);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
