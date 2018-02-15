package com.training.ee.interceptor;

/**
 * Created by yusufyazici on 14/02/2018.
 */
public class MyObject {

    @LogInterceptor
    public String doSomething(){
        return "I did it";
    }

    @UserPasswordInterceptor
    public String checkIfUsersAreTheSame(String username, String password, String isim, String encyPassword) {

        if (username.equals(isim) && password.equals(encyPassword)){
            return "OK";
        }
        return "NOK";

    }
}
