package com.maffy.example.exception;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/26/13
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class WordReplacerException extends Exception {

    public WordReplacerException (String message) {
        super(message);
    }

    public WordReplacerException (String message, Throwable throwable) {
        super(message, throwable);
    }
}
