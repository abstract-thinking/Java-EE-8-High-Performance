package com.example.dynamic.lookups;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Provider;
import java.lang.annotation.Annotation;

@ApplicationScoped
public class DynamicInstance {

    @Inject
    private Provider<MyService> myServiceProvider;

    @Inject
    private Instance<MyService> myServices;

    public MyService currentService() {
        return myServiceProvider.get();
    }

    public MyService newService(final Annotation qualifier) {
        return myServices.select(qualifier).get();
    }

    private static class MyService {

    }
}
