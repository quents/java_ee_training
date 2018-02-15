package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by yusufyazici on 15/02/2018.
 */


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
            propertyName = "destination",
            propertyValue = "MyTopic"),
        @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Topic"
        )})
public class TopicListener3 implements MessageListener {

    public void onMessage(Message message) {
        if (message instanceof TextMessage){
             TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("TopicListener 3 message: " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
