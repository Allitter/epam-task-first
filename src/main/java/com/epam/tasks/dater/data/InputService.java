package com.epam.tasks.dater.data;

import com.epam.tasks.dater.data.exceptions.IncorrectArgumentException;

public interface InputService {

    int readInt() throws IncorrectArgumentException;

    int readIntWithMessage(String message) throws IncorrectArgumentException;

}
