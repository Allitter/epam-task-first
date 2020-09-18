package com.epam.tasks.dater.view;

public class ConsoleResultPrinterFactory implements ResultPrinterFactory {

    @Override
    public ResultPrinter createResultPrinter() {
        return new ConsoleResultPrinter();
    }

}
