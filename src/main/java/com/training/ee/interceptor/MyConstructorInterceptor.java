package com.training.ee.interceptor;

import com.training.ee.cdi.PersonHolder;
import com.training.ee.cdi.TestConstructorInterceptor;

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by yusufyazici on 15/02/2018.
 */
@Interceptor
@NewAnnotation
public class MyConstructorInterceptor implements Serializable {

    @AroundConstruct
    public Object constructCall(InvocationContext ic) throws Exception {

        Object proceed = ic.proceed();
        if (proceed instanceof TestConstructorInterceptor){
        //if (proceed.getClass().isAssignableFrom(PersonHolder.class)){
            TestConstructorInterceptor holder = (TestConstructorInterceptor) proceed;
            holder.setId(UUID.randomUUID().toString());
        }
        return proceed;

    }
}
