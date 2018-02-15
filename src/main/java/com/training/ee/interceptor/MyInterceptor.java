package com.training.ee.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

/**
 * Created by yusufyazici on 14/02/2018.
 */

//bu loglama security icin kullanilabilir

@LogInterceptor
@Interceptor
public class MyInterceptor {

    @AroundInvoke
    public Object abc(InvocationContext context){
        Object proceed = null;
        try {
            Method method = context.getMethod();
            LogInterceptor annotation = method.getAnnotation(LogInterceptor.class);
            String logType = "null";

            proceed = context.proceed();
            if (proceed instanceof String){
                String string = (String) proceed;
                string += "_logged_" + logType;
                return string;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proceed;
    }

}
