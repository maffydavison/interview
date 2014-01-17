package com.maffy.example.model;

import org.junit.Before;
import org.junit.Test;

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

        for (int i : result) {
            System.out.println(i);
        }

    }
}
