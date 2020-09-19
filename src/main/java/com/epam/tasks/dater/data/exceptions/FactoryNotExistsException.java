package com.epam.tasks.dater.data.exceptions;

public class FactoryNotExistsException extends Exception {

    public FactoryNotExistsException() {
        super("Factory Not Exists");
    }

    public FactoryNotExistsException(String message) {
        super(message);
    }
}
