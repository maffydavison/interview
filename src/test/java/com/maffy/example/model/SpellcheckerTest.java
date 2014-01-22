package com.maffy.example.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by maryanndavison on 1/21/14.
 */
public class SpellcheckerTest {

    Spellchecker service;

    @Before
    public void setUp() throws Exception {
        service = new Spellchecker("/Users/maryanndavison/ideaGit/testFile.txt");
    }

        /*
     Case (upper/lower) errors: "inSIDE" => "inside"
     Repeated letters: "jjoobbb" => "job"
     Incorrect vowels: "weke" => "wake"
     */

    @Test
    public void testCorrect() throws Exception {
        String result = service.correct("inSIDE");
        assert result != null;
        assertEquals("inside", result);

        result = service.correct("jjoobbb");
        assert result != null;
        assertEquals("job", result);

        result = service.correct("weke");
        assert result != null;
        assertEquals("wake", result);
    }
}
