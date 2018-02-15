package com.training.ee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by yusufyazici on 15/02/2018.
 */
@Path("/jms")
public class JMSRest {

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "java:/jms/queue/MyQueue")
    private Queue queue;


    @GET
    public String sendMessage(){
        jmsContext.createProducer().send(queue, "Hello from Rest");
        System.out.println("Sender thread: " + Thread.currentThread().getName());
        return "OK";

    }
}
