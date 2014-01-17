package com.maffy.example.model;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: maryannfinnerty
 * Date: 11/10/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordReverseTest extends TestCase {


    WordReverse wordReverse = new WordReverse();
    String input;
    String result;

    public void testNullWord() {
        input = null;
        result = wordReverse.reverse(input);
        assert result == null;
    }

    public void testEmptyWord() {
        input = "";
        result = wordReverse.reverse(input);
        assert result == null;
    }

    public void testSingleWord() {
        input = "Hello";
        result = wordReverse.reverse(input);
        assert result != null;
        assert result.equals(input);
    }

    public void testMultiWord() {
        input = "Eureka was a great show";
        result = wordReverse.reverse(input);
        assert result != null;
        assert result.indexOf("Eureka") == 17;
        assert result.indexOf("show") == 0;

    }

    public void testReverseString() {
        input = "Hello";
        String output = "olleH";
        result = wordReverse.reverseString(input);
        assert result != null;
        assert result.equals(output);
    }
}
