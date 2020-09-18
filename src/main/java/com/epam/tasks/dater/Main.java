package com.epam.tasks.dater;

//TODO
//  Составить программу, которая по заданным году и номеру месяца определяет
//  количество дней в этом месяце и корректно определялись все високосные года.

import com.epam.tasks.dater.data.ConsoleInputServiceFactory;
import com.epam.tasks.dater.data.InputService;
import com.epam.tasks.dater.data.InputServiceFactory;
import com.epam.tasks.dater.logic.DateProcessor;
import com.epam.tasks.dater.view.ConsoleResultPrinter;
import com.epam.tasks.dater.view.ResultPrinter;

public class Main {

    public static void main(String[] args) {
        try {
            InputServiceFactory inputServiceFactory = new ConsoleInputServiceFactory();
            InputService inputService = inputServiceFactory.getInputService();

            int year = inputService.readIntWithMessage("Input year: ");
            int month = inputService.readIntWithMessage("Input month number: ");

            DateProcessor dateProcessor = new DateProcessor();
            int numberOfDays = dateProcessor.findNumberOfDays(month, year);

            ResultPrinter resultPrinter = new ConsoleResultPrinter();
            resultPrinter.print("Number of days in the month: ", numberOfDays);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}