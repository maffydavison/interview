package com.maffy.example.model;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Maffy Davison on 12/17/13.
 */
public class InterviewTest {

    Interview service;

    @Before
    public void setUp() throws Exception {
        service = new Interview();
    }

    @Test
    public void testFindWordInString() throws Exception {
        String input = "My dog has fleas";
        String word = "fleas";
        int result = service.findWordInString(input, word);
        assert result == 11;
    }

    @Test
    public void testFindWordInString2() throws Exception {
        String input = "My dog fred has fleas";
        String word = "fleas";
        int result = service.findWordInString(input, word);
        assert result == 16;
    }
}
