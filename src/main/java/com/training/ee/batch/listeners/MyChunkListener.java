package com.training.ee.batch.listeners;

import javax.batch.api.chunk.listener.AbstractChunkListener;
import javax.inject.Named;

/**
 * Created by yusufyazici on 16/02/2018.
 */
@Named
public class MyChunkListener extends AbstractChunkListener {

    @Override
    public void beforeChunk() throws Exception {
        System.out.println("before chunk");
    }

    @Override
    public void onError(Exception ex) throws Exception {
        System.out.println("on error");
    }

    @Override
    public void afterChunk() throws Exception {
        System.out.println("after chunk");
    }
}
