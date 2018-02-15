package com.training.ee.cdi;

import javax.enterprise.inject.Default;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@Default
public class ExecuteImpl2 implements IExecute {

    public String execute(){
        return "execute 2";
    }
}
