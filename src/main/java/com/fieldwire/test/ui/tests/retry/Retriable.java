package com.fieldwire.test.ui.tests.retry;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Custom annotation that signals that a configuration method should be retried.
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface Retriable {

    /**
     * @return - How many times should a configuration be retried.
     */
    int attempts() default 1;
}