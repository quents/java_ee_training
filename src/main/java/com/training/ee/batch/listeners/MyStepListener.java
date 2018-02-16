package com.training.ee.batch.listeners;

import javax.batch.api.listener.AbstractStepListener;
import javax.inject.Named;

/**
 * Created by yusufyazici on 16/02/2018.
 */
@Named
public class MyStepListener extends AbstractStepListener {

    @Override
    public void beforeStep() throws Exception {
        System.out.println("before step");
    }

    @Override
    public void afterStep() throws Exception {
        System.out.println("after step");
    }
}
