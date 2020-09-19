package com.epam.tasks.dater.data.exceptions;

public class IncorrectArgumentException extends Exception {

    public IncorrectArgumentException() {
        super("Incorrect argument");
    }

    public IncorrectArgumentException(String message) {
        super(message);
    }

}
