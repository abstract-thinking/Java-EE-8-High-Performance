package com.example;

import com.example.container.Container;
import com.example.container.time.TimeServiceFactory;
import com.example.container.time.TimeServiceImpl;
import com.example.container.time.TimerService;

public class Application {

    public static void main(String[] args) {
        final TimerService timerService = TimeServiceFactory.create();
        System.out.println(timerService.now());

        final Container container = new Container().register(TimerService.class, TimeServiceImpl.class);

        final TimerService timerServiceFromC1 = container.get1(TimerService.class);
        System.out.println(timerServiceFromC1.now());


        final TimerService timerServiceFromC2 = container.get2(TimerService.class);
        System.out.println(timerServiceFromC2.now());
    }

}
