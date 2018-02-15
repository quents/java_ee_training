package com.training.ee.interceptor;

import javax.interceptor.InterceptorBinding;
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
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD})
public @interface UserPasswordInterceptor {

    //String logType() default "test";
}
