package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

/**
 * Created by yusufyazici on 15/02/2018.
 */


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
            propertyName = "destination",
            propertyValue = "MyQueue"),
        @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Queue"
        )})
public class QueueListener2 implements MessageListener {

    public void onMessage(Message message) {
        if (message instanceof TextMessage){
             TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("QueueListener2 message: " + textMessage.getText());
                System.out.println("Consumer thread: " + Thread.currentThread().getName());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
