package com.epam.tasks.dater.view;

import com.epam.tasks.dater.data.exceptions.FactoryNotExistsException;

public class ResultPrinterFactory {

    public static ResultPrinter createResultPrinter(String name) throws FactoryNotExistsException {
        switch (name.toLowerCase()) {
            case "console" :
                return new ConsoleResultPrinter();
            default:
                throw new FactoryNotExistsException("Incorrect ResultPrinter name");
        }
    }
}
