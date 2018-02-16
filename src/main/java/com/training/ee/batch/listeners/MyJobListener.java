package com.training.ee.batch.listeners;

import javax.batch.api.listener.AbstractJobListener;
import javax.inject.Named;

/**
 * Created by yusufyazici on 16/02/2018.
 */
@Named
public class MyJobListener extends AbstractJobListener {

    @Override
    public void beforeJob() throws Exception {
        System.out.println("before job");
    }

    @Override
    public void afterJob() throws Exception {
        System.out.println("after job");
    }
}
