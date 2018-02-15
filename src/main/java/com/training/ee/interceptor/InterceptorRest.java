package com.training.ee.interceptor;

import com.training.ee.cdi.PersonHolder;
import com.training.ee.cdi.TestConstructorInterceptor;
import com.training.ee.model.Person;


import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Created by yusufyazici on 14/02/2018.
 */
//interceptor araya girmek

@Path("/inter")
public class InterceptorRest {

    @Inject
    private MyObject myObject;

    @Inject
    private PersonHolder personHolder;

    @Inject
    private TestConstructorInterceptor testConstructorInterceptor;

    @GET
    public String runMyObjectMethod(){
        return myObject.doSomething();
    }

    @POST
    @Path("/securityControl")
    public String checkIfTheUserCanLogIn(@HeaderParam("username") String username,
                                         @HeaderParam("password") String password,
                                         Person person){

        return myObject.checkIfUsersAreTheSame(username, password, person.getIsim(), person.getEncyPassword());

    }

    @POST
    @Path("/myConstructorInterceptor")
    @Produces({"application/json"})
    public TestConstructorInterceptor myMethod(Person person){
        testConstructorInterceptor.setPerson(person);
        return testConstructorInterceptor;
    }
}
