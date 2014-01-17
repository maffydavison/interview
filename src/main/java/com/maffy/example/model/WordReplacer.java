package com.maffy.example.model;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/25/13
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */

import com.maffy.example.exception.WordReplacerException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class lets you determine how many times a particular word occurs in a file
 * and allows replacing all occurrences of a word with another word.
 *
 * For the purposes of this class, a "word" is any non-empty sequence of the letters
 * 'A' through 'Z', including both upper and lowercase.  Words are case sensitive,
 * meaning two words with the same sequence of letters are not the same if the
 * capitalization differs between them.
 *
 * When implementing this class, you are free to add additional methods and
 * instance variables, but the signatures of the existing methods should not
 * be modified except to allow throwing exceptions.
 * It is safe to assume file sizes are small enough to fit into memory.
 * For any questions about functionality that are not specified here,
 * do whatever you feel is reasonable.
 */
public class WordReplacer {

    private List<String> text;
    private File file;

    /**
     * Instantiates the WordReplacer class and initializes the values for the data
     * contained in the file (text) and the file itself
     *
     * @param textFile
     * @throws WordReplacerException
     */
    public WordReplacer(File textFile) throws WordReplacerException {
        this.text = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader (new FileReader(textFile));
            String line;
            while ((line = in.readLine()) != null) {

                text.add(line);
            }
        }
        catch (IOException e) {
            throw new WordReplacerException(e.getMessage(), e);
        }
        file = textFile;
    }

    /**
     * Finds the occurrences of a word in the file
     *
     * @param word
     * @return
     */
    public int getCountOfOccurrences(String word) {
        int result = 0;
        Pattern p = Pattern.compile(word);
        for (String line : text) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                result++;
            }
        }
        return result;
    }

    /**
     * Matcher returns a string after the replace, so the return value is screwy,
     * but tests show that the replacement does take place - the replacements are NOT saved
     * to the file - though they could be if that becomes a requirement.  For now, the call
     * to writeToFile() is required for the save to disk.
     *
     * @param originalWord
     * @param newWord
     * @return
     */
    public int replaceAllOccurrences(String originalWord, String newWord) {
        int result = getCountOfOccurrences(originalWord);
        Pattern p = Pattern.compile(originalWord);

        // create a working list until replacements are done
        List<String> working = new ArrayList<String>();
        for (String line : text) {
            Matcher m = p.matcher(line);
            working.add(m.replaceAll(newWord));
        }
        setText(working);

        return result;
    }

    /**
     * Standard Java way to write to a file
     *
     * @param outfile
     * @throws WordReplacerException
     */
    public void writeToFile(File outfile) throws WordReplacerException {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
            for (String line : text) {
                out.write(line);
            }
            out.close();
        }
        catch (IOException e) {
            throw new WordReplacerException(e.getMessage(), e);
        }
    }

    /**
     * Since someone may want to save changes made, a simple method that uses
     * the file provided in the constructor is convenient.
     *
     * @throws WordReplacerException
     */
    public void writeToFile() throws WordReplacerException {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(this.file));
            for (String line : text) {
                out.write(line);
            }
            out.close();
        }
        catch (IOException e) {
            throw new WordReplacerException(e.getMessage(), e);
        }
    }

    /**
     * Thought it would be useful to have a write method that just took a filename
     * instead of a File object
     *
     * @param outFilename
     * @throws WordReplacerException
     */
    public void writeToFile(String outFilename) throws WordReplacerException {
        Path filePath = Paths.get(outFilename);
        try {
            OutputStream out = new
                    BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE));
            for (String line : text) {
                out.write(line.getBytes());
            }
            out.close();
        }
        catch (IOException e) {
            throw new WordReplacerException(e.getMessage(), e);
        }
    }
    /**
     * Convenience method for testing
     *
     * @return list<String> of the text in the file used to construct the object
     */
    public List<String> getText() {
        return this.text;
    }

    /**
     * No requirement to rewrite file when replacements are done, so we only need
     * to reset the value of the text member variable - thus, the setter
     *
     * @param text
     */
    public void setText(List<String> text) {
        this.text = text;
    }
}
