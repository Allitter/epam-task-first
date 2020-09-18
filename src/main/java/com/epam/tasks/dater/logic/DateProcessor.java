package com.epam.tasks.dater.logic;

import com.epam.tasks.dater.data.IncorrectArgumentException;

public class DateProcessor {

    public int findNumberOfDays(int month, int year)
            throws IncorrectArgumentException {

        if (!isMonthValid(month)) {
            throw new IncorrectArgumentException("Month must be between 1 and 12");
        }

        if (!isYearValid(year)) {
            throw new IncorrectArgumentException("Year must be between 0 and 9999");
        }

        return findDaysInMonth(month, isLeapYear(year));
    }

    private boolean isMonthValid(int month) {
        return month < 13 && month > 0;
    }

    private boolean isYearValid(int year) {
        return year >= 0 && year < 10000;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private int findDaysInMonth(int month , boolean isLeapYear)
            throws IncorrectArgumentException {

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear ? 29 : 28;
            default:
                throw new IncorrectArgumentException("Incorrect day number");
        }
    }
}
