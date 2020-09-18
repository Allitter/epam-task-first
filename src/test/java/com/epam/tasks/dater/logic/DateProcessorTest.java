package com.epam.tasks.dater.logic;

import com.epam.tasks.dater.data.IncorrectArgumentException;
import org.junit.Assert;
import org.junit.Test;

public class DateProcessorTest {
    private DateProcessor dateProcessor = new DateProcessor();

    @Test
    public void testGetNumberOfDaysWithCorrectMonthAndYear() throws IncorrectArgumentException {
        int expected = 31;

        int actual = dateProcessor.findNumberOfDays(10, 2005);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfDaysInFebruary() throws IncorrectArgumentException {
        int expected = 28;

        int actual = dateProcessor.findNumberOfDays(2, 2018);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfDaysInFebruaryWithLeapYear() throws IncorrectArgumentException {
        int expected = 29;

        int actual = dateProcessor.findNumberOfDays(2, 2020);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IncorrectArgumentException.class)
    public void testGetNumberOfDaysWithIncorrectMonth() throws IncorrectArgumentException {
        dateProcessor.findNumberOfDays(13, 2005);
    }

    @Test(expected = IncorrectArgumentException.class)
    public void testGetNumberOfDaysWithNegative() throws IncorrectArgumentException {
        dateProcessor.findNumberOfDays(-10, -2005);
    }
}
