package com.maffy.example.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maryannfinnerty on 12/3/13.
 */
public class WordUniqueTest {

    String [] words = { "a", "ab", "abc", "ba", "cba", "def"};
    char [] dictionary = { 'a', 'b' };
    char [] chars = {'a', 'b', 'a', 'c', 'd'};

    WordUnique service = new WordUnique();

    @Test
    public void testGetValidWords() throws Exception {
        List result = service.getValidWords(words, dictionary);
        assert result != null;
        assert result.size() == 2;
    }

    @Test
    public void testFindFirstUnique() throws Exception {
       char result = service.findFirstUnique(chars);
        assert result == 'b';
    }

    @Test
    public void testFindFirstUniqueToo() throws Exception {
        char []charsToo = {'a', 'a', 'a', 'a', 'b', 'a', 'a'};
        char result = service.findFirstUnique(charsToo);
        assert result == 'b';
    }

    @Test
    public void testFindFirstUniqueTre() throws Exception {
        char []charsToo = {'a', 'b', 'c', 'd', 'b', 'e', 'a'};
        char result = service.findFirstUnique(charsToo);
        assert result == 'c';
    }

    @Test
    public void testFindWordInString() throws Exception {
        String input = "My dog has fleas";
        String word = "fleas";
        int result = service.findWordInString(input, word);
        assert result == 11;
    }

    @Test
    public void testFindLongestWord() throws Exception {
        List<String> input = new ArrayList<String>();
        input.add("abc");
        input.add("def");
        input.add("ghijk");
        input.add("lmno");
        input.add("pq");
        String result = service.getLongestWord(input);
        assert result != null;
        assert result.contains("ghijk");


    }

    @Test
    public void testRepeatedChars() throws Exception {
        Assert.assertEquals("bbca", service.getRepeatedChars("bbbaac", "ddddcbba"));
        Assert.assertEquals("dda", service.getRepeatedChars("ddaa", "ddddcbba"));
    }
}
