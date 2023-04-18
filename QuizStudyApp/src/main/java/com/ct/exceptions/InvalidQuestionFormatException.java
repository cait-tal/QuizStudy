package com.ct.exceptions;

public class InvalidQuestionFormatException extends Exception{
    public InvalidQuestionFormatException() {
        super();
    }

    public InvalidQuestionFormatException(String message) {
        super(message);
    }

    public InvalidQuestionFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidQuestionFormatException(Throwable cause) {
        super(cause);
    }

    protected InvalidQuestionFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
