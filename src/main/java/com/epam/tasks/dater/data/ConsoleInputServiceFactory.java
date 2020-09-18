package com.epam.tasks.dater.data;

public class ConsoleInputServiceFactory implements InputServiceFactory {

    @Override
    public InputService getInputService() {
        return new ConsoleInputService();
    }

}
