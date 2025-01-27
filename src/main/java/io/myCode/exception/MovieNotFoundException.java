package io.myCode.exception;


public class MovieNotFoundException extends RuntimeException {

    // Constructor that accepts a message
    public MovieNotFoundException(String msg) {
        super(msg);
    }
}
