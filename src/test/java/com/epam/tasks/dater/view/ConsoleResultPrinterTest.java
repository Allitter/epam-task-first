package com.epam.tasks.dater.view;

import org.junit.*;

import java.io.PrintStream;

public class ConsoleResultPrinterTest {
    public static final String INPUT_MESSAGE = "message";
    public static final String CAPTION = "Caption";
    public static final int PRIMITIVE = 10;
    public static final Object OBJECT = new Object();
    private static PrintStream outputStream;
    private static MockOutputStream mockOutputStream = new MockOutputStream();
    private static ConsoleResultPrinter resultPrinter;

    @BeforeClass
    public static void toDoBeforeAllTests() {
        outputStream = System.out;
        System.setOut(new PrintStream(mockOutputStream));
        resultPrinter = new ConsoleResultPrinter();
    }

    @AfterClass
    public static void toDoAfterAllTests() {
        System.setOut(outputStream);
    }

    @Before
    public void toDoBeforeTest() {
        mockOutputStream.reset();
    }

    @Test
    public void printWithMessage() {
        resultPrinter.print(INPUT_MESSAGE);
        String actual = mockOutputStream.getContent();

        Assert.assertEquals(INPUT_MESSAGE, actual);
    }

    @Test
    public void printWithCaptionAndPrimitive() {
        String expected = String.format("%s:\t%s", CAPTION, PRIMITIVE);

        resultPrinter.print(CAPTION, PRIMITIVE);
        String actual = mockOutputStream.getContent();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printWithCaptionAndObject() {
        String expected = String.format("%s:\t%s", CAPTION, OBJECT);

        resultPrinter.print(CAPTION, OBJECT);
        String actual = mockOutputStream.getContent();

        Assert.assertEquals(expected, actual);
    }
}
