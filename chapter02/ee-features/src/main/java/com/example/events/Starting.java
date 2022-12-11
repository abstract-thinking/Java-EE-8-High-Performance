package com.example.events;

import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.enterprise.util.TypeLiteral;
import java.lang.annotation.Annotation;
import java.util.concurrent.CompletionStage;

public class Starting implements Event {

    @Override
    public void fire(Object event) {

    }

    @Override
    public Event select(Annotation... qualifiers) {
        return null;
    }

    @Override
    public Event select(TypeLiteral subtype, Annotation... qualifiers) {
        return null;
    }

    @Override
    public Event select(Class subtype, Annotation... qualifiers) {
        return null;
    }

    @Override
    public CompletionStage fireAsync(Object event, NotificationOptions options) {
        return null;
    }

    @Override
    public CompletionStage fireAsync(Object event) {
        return null;
    }
}
