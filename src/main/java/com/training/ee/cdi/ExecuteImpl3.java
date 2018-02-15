package com.training.ee.cdi;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@Any
@Named("yusuf1")
public class ExecuteImpl3 implements IExecute, Serializable {

    public String execute(){
        return "execute 3";
    }
}
