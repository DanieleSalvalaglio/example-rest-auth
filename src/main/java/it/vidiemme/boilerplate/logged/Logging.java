package it.vidiemme.boilerplate.logged;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

@InterceptorBinding 
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Inherited 
public @interface Logging {
}