package com.epam.tasks.dater.data;

import java.io.IOException;

public interface InputService {

    int readInt() throws IncorrectArgumentException, IOException;

    int readIntWithMessage(String message) throws IncorrectArgumentException, IOException;

}
