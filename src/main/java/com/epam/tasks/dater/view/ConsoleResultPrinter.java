package com.epam.tasks.dater.view;

public class ConsoleResultPrinter implements ResultPrinter {

    @Override
    public <T> void print(String caption, T result) {
        System.out.printf("%s:\t%s", caption, result);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

}
