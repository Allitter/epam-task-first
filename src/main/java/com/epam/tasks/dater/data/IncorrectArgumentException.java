package com.epam.tasks.dater.data;

public class IncorrectArgumentException extends Exception {
    public IncorrectArgumentException() {
        super("Incorrect argument");
    }

    public IncorrectArgumentException(String message) {
        super(message);
    }
}
