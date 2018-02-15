package com.training.ee.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

/**
 * Created by yusufyazici on 14/02/2018.
 */

//bu loglama security icin kullanilabilir

@UserPasswordInterceptor
@Interceptor
public class MyUserPasswordInterceptor {

    @AroundInvoke
    public Object abc(InvocationContext context){
        Object proceed = null;
        try {
            Method method = context.getMethod();
            UserPasswordInterceptor annotation = method.getAnnotation(UserPasswordInterceptor.class);
            String logType = "null";

            proceed = context.proceed();
            if (proceed instanceof String){
                String aBoolean = (String) proceed;
                if (aBoolean == "OK"){
                    return "Dogru!";
                }
                return "Yanlis!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proceed;
    }

}
