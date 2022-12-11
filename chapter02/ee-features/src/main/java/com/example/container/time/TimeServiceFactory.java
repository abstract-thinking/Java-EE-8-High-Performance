package com.example.container.time;

public class TimeServiceFactory {

    public static TimerService create() {
        if (useDefault()) {
            return new TimeServiceImpl();
        }

        return new MockTimeService();
    }

    private static boolean useDefault() {
        return true;
    }
}