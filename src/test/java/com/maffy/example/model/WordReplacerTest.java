package com.maffy.example.model;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/25/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordReplacerTest extends TestCase {

    private File file;
    private WordReplacer replacer;
    private File outFile;

    @Before
    public void setUp() throws Exception {
        file = new File("/Users/maryannfinnerty/ideaGit/example/testFile.txt");
        outFile = new File("/Users/maryannfinnerty/ideaGit/example/testonly.txt");
        replacer = new WordReplacer(file);
    }

    @After
    public void tearDown() throws Exception {
        if (outFile.exists()) {
            outFile.delete();
        }
    }

    public void testReadFile() throws Exception {
        assert replacer != null;
        assert !replacer.getText().isEmpty();
    }

    public void testCountOccurrences() throws Exception {
         assert replacer.getCountOfOccurrences("words") == 2;

    }

    public void testCountWrongCase() throws Exception {
        assert replacer.getCountOfOccurrences("WORDS") == 0;
    }

    public void testReplaceAllOccurrences() throws Exception {
        assert replacer.replaceAllOccurrences("words", "yoohoo") == 2;
        assert replacer.getCountOfOccurrences("words") == 0;
        assert replacer.getCountOfOccurrences("yoohoo") == 2;
    }

    public void testWriteToFile() throws Exception {
        assert replacer != null;
        replacer.writeToFile(outFile);
        assert outFile.exists();
    }

    public void testWriteToFileNio() throws Exception {
        assert replacer != null;
        replacer.writeToFile(outFile.getAbsolutePath());
        assert outFile.exists();
    }

    public void testWriteToOriginalFile() throws Exception {
        assert replacer != null;
        Long modified = file.lastModified();
        replacer.writeToFile();
        assert file.exists();
        assert file.lastModified() > modified;
    }
}
