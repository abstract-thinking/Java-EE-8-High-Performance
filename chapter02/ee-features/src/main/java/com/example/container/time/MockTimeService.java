package com.example.container.time;

import java.time.LocalDateTime;
import java.time.Month;

public class MockTimeService implements TimerService {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.of(2017, Month.SEPTEMBER, 4, 19, 0);
    }
}
