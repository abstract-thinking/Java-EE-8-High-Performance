package com.example.container.time;

import java.time.LocalDateTime;

public class TimeServiceImpl implements  TimerService{

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
