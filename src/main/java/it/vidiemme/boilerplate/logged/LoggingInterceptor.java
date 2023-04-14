package it.vidiemme.boilerplate.logged;

import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logging
@Priority(10)
@Interceptor
public class LoggingInterceptor {

    private final Logger log = Logger.getLogger(LoggingInterceptor.class);

    /* Method with logged resource */
    @AroundInvoke
    Object logInvocation(InvocationContext context) throws Exception {
        /* Get the class name of the logged resource */
        String className = context.getTarget().getClass().getName();
        /* Get the method name of the logged resource */
        String methodName = context.getMethod().getName();
        /* Log the method name of the logged resource */
        log.info("Calling method: " + methodName + " on class: " + className);
        Object ret = context.proceed();
        return ret;
    }
}