package com.edu.flynote.check;

public class SpamForbiddenException extends RuntimeException {

    public SpamForbiddenException(String message) {
        super(message);
    }
}
