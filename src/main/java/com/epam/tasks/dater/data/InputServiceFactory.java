package com.epam.tasks.dater.data;

import com.epam.tasks.dater.data.exceptions.FactoryNotExistsException;

public class InputServiceFactory {

    public static InputService createInputService(String name) throws FactoryNotExistsException {
        switch (name.toLowerCase()) {
            case "console" :
                return new ConsoleInputService();
            default:
                throw new FactoryNotExistsException("Incorrect InputService name");
        }
    }
}
