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

        assert result.length == (one.length + two.length);
        assert result[0] == 1;
        assert result[1] == 3;
        assert result[2] == 5;

    }
}
