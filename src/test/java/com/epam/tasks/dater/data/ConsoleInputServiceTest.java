package com.epam.tasks.dater.data;

import com.epam.tasks.dater.data.exceptions.IncorrectArgumentException;
import com.epam.tasks.dater.view.MockOutputStream;
import org.junit.*;

import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleInputServiceTest {
    public static final String CORRECT_PARAMETER = "1020";
    public static final String INCORRECT_PARAMETER = "incorrect parameter";
    public static final String INPUT_MESSAGE = "Input int: ";
    private static InputStream inputStream;
    private static PrintStream outputStream;
    private static MockInputStream mockInputStream = new MockInputStream();
    private static MockOutputStream mockOutputStream = new MockOutputStream();
    private static ConsoleInputService inputService;

    @BeforeClass
    public static void toDoBeforeAllTests() {
        inputStream = System.in;
        outputStream = System.out;
        System.setIn(mockInputStream);
        System.setOut(new PrintStream(mockOutputStream));
        inputService = new ConsoleInputService();
    }

    @AfterClass
    public static void toDoAfterAllTests() {
        System.setIn(inputStream);
        System.setOut(outputStream);
    }

    @Before
    public void toDoBeforeTest() {
        mockOutputStream.reset();
    }

    @Test
    public void readIntWithCorrectParameters() throws IncorrectArgumentException {
        mockInputStream.setInput(CORRECT_PARAMETER);
        int expected = Integer.parseInt(CORRECT_PARAMETER);

        int actual = inputService.readInt();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IncorrectArgumentException.class)
    public void readIntWithIncorrectParameters() throws IncorrectArgumentException {
        mockInputStream.setInput(INCORRECT_PARAMETER);

        inputService.readInt();
    }

    @Test
    public void readIntWithMessageTestMessageOutput() throws IncorrectArgumentException {
        mockInputStream.setInput(CORRECT_PARAMETER);

        inputService.readIntWithMessage(INPUT_MESSAGE);
        String actual = mockOutputStream.getContent();

        Assert.assertEquals(INPUT_MESSAGE, actual);
    }

    @Test
    public void readIntWithMessageWithCorrectParameters() throws IncorrectArgumentException {
        mockInputStream.setInput(CORRECT_PARAMETER);
        int expected = Integer.parseInt(CORRECT_PARAMETER);

        int actual = inputService.readIntWithMessage(INPUT_MESSAGE);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IncorrectArgumentException.class)
    public void readIntWithMessageWithIncorrectParameters() throws IncorrectArgumentException {
        mockInputStream.setInput(INCORRECT_PARAMETER);

        inputService.readIntWithMessage(INPUT_MESSAGE);

        inputService.readInt();
    }
}
