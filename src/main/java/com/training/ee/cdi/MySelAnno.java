package com.training.ee.cdi;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD})
@Documented
public @interface MySelAnno {
}
