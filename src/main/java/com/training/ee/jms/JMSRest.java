package com.training.ee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
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


    @Resource(lookup = "java:/jms/queue/MyTopic")
    private Topic topic;


    @GET
    public String sendMessage(){
        jmsContext.createProducer().send(queue, "Hello from Rest");
        System.out.println("Sender thread: " + Thread.currentThread().getName());
        return "OK";

    }

    @GET
    @Path("/topic")
    public String sendMessageTopic(){
        jmsContext.createProducer().send(topic, "Hello Topic");
        return "OK";

    }
}
