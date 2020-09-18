package com.epam.tasks.dater.view;

public interface ResultPrinter {

    <T> void print(String caption, T number);

    void print(String message);

}
