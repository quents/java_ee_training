package com.training.ee.cdi;

import javax.enterprise.inject.Any;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@Any
@MySelAnno
public class ExecuteImpl1 implements IExecute {

    public String execute(){
        return "execute 1";
    }
}
