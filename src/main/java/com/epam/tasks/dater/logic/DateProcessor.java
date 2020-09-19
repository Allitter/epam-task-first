package com.epam.tasks.dater.logic;

import com.epam.tasks.dater.data.exceptions.IncorrectArgumentException;

public class DateProcessor {
    public static final int MIN_VALID_MONTH = 0;
    public static final int MAX_VALID_YEAR = 9999;
    public static final int MAX_VALID_MONTH = 12;
    public static final int MIN_VALID_YEAR = 1;
    public static final int FEBRUARY_DAYS_LEAP = 29;
    public static final int FEBRUARY_DAYS_NON_LEAP = 28;

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
        return month <= MAX_VALID_MONTH && month >= MIN_VALID_MONTH;
    }

    private boolean isYearValid(int year) {
        return year >= MIN_VALID_YEAR && year <= MAX_VALID_YEAR;
    }

    // Leap year must be divided by 4 without residue and it shouldn't be century except centuries that is divided by 4
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
                return isLeapYear ? FEBRUARY_DAYS_LEAP : FEBRUARY_DAYS_NON_LEAP;
            default:
                throw new IncorrectArgumentException("Incorrect day number");
        }
    }

}
