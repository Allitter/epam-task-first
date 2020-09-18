package com.epam.tasks.dater.logic;

import com.epam.tasks.dater.data.IncorrectArgumentException;
import org.junit.Assert;
import org.junit.Test;

public class DateProcessorTest {
    private DateProcessor dateProcessor = new DateProcessor();

    @Test
    public void testGetNumberOfDaysWithCorrectMonthAndYear() throws IncorrectArgumentException {
        int result = dateProcessor.findNumberOfDays(10, 2005);

        Assert.assertEquals(31, result);
    }

    @Test
    public void testGetNumberOfDaysInFebruary() throws IncorrectArgumentException {
        int result = dateProcessor.findNumberOfDays(2, 2018);

        Assert.assertEquals(28, result);
    }

    @Test
    public void testGetNumberOfDaysInFebruaryWithLeapYear() throws IncorrectArgumentException {
        int result = dateProcessor.findNumberOfDays(2, 2020);

        Assert.assertEquals(29, result);
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
