package com.example.container;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class LoggingHandler implements InvocationHandler {

    private final Object delegate;

    private final Logger logger;

    public LoggingHandler(final Object delegate, final Class<?> api) {
        this.delegate = delegate;
        this.logger = Logger.getLogger(api.getName());
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        logger.info(() -> "Calling " + method.getName());

        try {
            return method.invoke(delegate, objects);
        } catch (final InvocationTargetException ite) {
            throw ite.getTargetException();
        } finally {
            logger.info(() -> "Called " + method.getName());
        }

    }
}
