package com.maffy.example.model;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Maffy Davison on 12/16/13.
 */
public class NumberPlayTest {

    private NumberPlay service;

    @Before
    public void setUp() {
        service = new NumberPlay();
    }

    @Test
    public void testFindDup() throws Exception {
        int [] input = {1,2,3,4,3,5};
        int result = service.findDup(input);
        assert result == 3;

    }

    @Test
    public void testFindDupWithZero() throws Exception {
        int [] input = {1,2,3,0,4,7,9,0};
        int result = service.findDupWithZero(input);
        assert result == 0;
    }

    @Test
    public void testSumSquares() throws Exception {
        int [] input = {2, 3, 4};
        int result = service.sumSquares(input);
        assert result == 29;
    }

    @Test
    public void testSingleAmidstDups() throws Exception {
        int [] input = {2, 1, 2, 3, 4, 5, 4, 3, 1, 5, 6};
        int result = service.findSingleAmidstDups(input);
        assert result == 6;
    }

    @Test
    public void testSingleAmidstDupsBruteForce() throws Exception {
        int [] input = {2, 1, 2, 3, 4, 5, 4, 3, 1, 5, 6};
        int result = service.findSingleAmidstDupsBruteForce(input);
        assert result == 6;
    }

}
