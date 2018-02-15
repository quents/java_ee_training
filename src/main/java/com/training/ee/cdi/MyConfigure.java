package com.training.ee.cdi;

import com.training.ee.model.Person;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * Created by yusufyazici on 14/02/2018.
 */
public class MyConfigure {

    @Produces
    @Named("impl3")
    @SessionScoped
    public IExecute createExecute(){
        return new ExecuteImpl3();
    }
}
