package com.maffy.example.model;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Maffy Davison on 1/5/14.
 */
public class CheckWriterTest {

    CheckWriter checkWriter;

    @Before
    public void setUp() throws Exception {
        checkWriter = new CheckWriter();
    }

    @Test
    public void testCheckWriting() throws Exception {
        Assert.assertEquals("ten", checkWriter.translate(10));
        Assert.assertEquals("twenty", checkWriter.translate(20));
        Assert.assertEquals("twenty five", checkWriter.translate(25));
        Assert.assertEquals("one hundred", checkWriter.translate(100));
        Assert.assertEquals("one hundred forty five", checkWriter.translate(145));
        Assert.assertEquals("one thousand", checkWriter.translate(1000));
        Assert.assertEquals("one thousand one hundred forty five", checkWriter.translate(1145));
        Assert.assertEquals("thirty thousand one hundred forty five", checkWriter.translate(30145));
        Assert.assertEquals("three hundred thousand one hundred forty five", checkWriter.translate(300145));
        Assert.assertEquals("five hundred forty five thousand one hundred forty five", checkWriter.translate(545145));
        Assert.assertEquals("two million five hundred forty five thousand one hundred forty five", checkWriter.translate(2545145));
        Assert.assertEquals("forty million five hundred forty five thousand one hundred forty five", checkWriter.translate(40545145));
        Assert.assertEquals("four hundred twenty two million five hundred forty five thousand one hundred forty five", checkWriter.translate(422545145));
    }
}
