package com.example.container;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

public class Container {

    private final Map<Class<?>, Class<?>> instances = new HashMap<>();

    public <A, I extends A> Container register(final Class<A> api, final Class<I> implementation) {
        instances.put(api, implementation);
        return this;
    }

    public <T> T get1(final Class<T> api) {
        try {
            return api.cast(ofNullable(instances.get(api))
                    .orElseThrow(() -> new IllegalArgumentException("No bean for api <" + api.getName() + ">"))
                    .getConstructor()
                    .newInstance()
            );

        } catch (final Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public <T> T get2(final Class<T> api) {
        try {
            final Object serviceInstance =  api.cast(ofNullable(instances.get(api))
                    .orElseThrow(() -> new IllegalArgumentException("No bean for api <" + api.getName() + ">"))
                    .getConstructor()
                    .newInstance()
            );

            return api.cast(Proxy.newProxyInstance(api.getClassLoader(), new Class<?>[]{api}, new LoggingHandler(serviceInstance, api)));
        } catch (final Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

}
