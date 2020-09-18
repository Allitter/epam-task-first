package com.epam.tasks.dater.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputService implements InputService {

    @Override
    public int readInt() throws IncorrectArgumentException {
        Scanner scanner = new Scanner(new FilterNotToCloseSystemIn(System.in));

        try {
            int result = scanner.nextInt();
            scanner.close();
            return result;
        } catch (InputMismatchException e) {
            scanner.close();
            throw new IncorrectArgumentException("Provided value is not int");
        }
    }

    @Override
    public int readIntWithMessage(String message) throws IncorrectArgumentException {
        System.out.print(message);
        return readInt();
    }
}
