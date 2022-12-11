package com.example.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;

import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Logger;


@Log("")
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggingInterceptor implements Serializable {

    @AroundInvoke
    public Object invoke(final InvocationContext context) throws Exception {
        final Logger logger = Logger.getLogger(context.getTarget().getClass().getName());
        logger.info(() -> "Calling " + context.getMethod().getName());
        try {
            return context.proceed();
        } finally {
            logger.info(() -> "Called " + context.getMethod().getName());
        }
    }
}
