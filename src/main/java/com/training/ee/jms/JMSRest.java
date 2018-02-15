package com.training.ee.jms;

import com.training.ee.cdi.PersonState;
import com.training.ee.model.Person;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

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

    @Resource(lookup = "java:/jms/queue/CommunicationTopic")
    private Topic communicationTopic;

    @Inject
    PersonStateCDI personStateCDI;


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


    @POST
    @Path("/createCommunication")
    public String createCommunication(Person person){

        PersonState personState = new PersonState();
        personState.setPerson(person);

        String uid = UUID.randomUUID().toString();
        personState.setUid(uid);
        personStateCDI.setMapWithUid(uid, personState);

        jmsContext.createProducer().send(communicationTopic, uid);
        return uid;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/communicationTopic")
    public PersonState sendCommunicationTopic(@QueryParam("uid") String uid){

        return personStateCDI.getPersonStateWithUid(uid);

    }


}
