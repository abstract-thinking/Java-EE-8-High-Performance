package com.example.events;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class LifecycleManager {

    @Inject
    private Event<Starting> startingEvent;

    public void starting() {
        final Starting event = new Starting();

        startingEvent.fire(event);
        startingEvent.fireAsync(event);
    }


}
