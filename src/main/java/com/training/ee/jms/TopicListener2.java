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
            propertyValue = "MyTopic"),
        @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Topic"
        )})
public class TopicListener2 implements MessageListener {

    public void onMessage(Message message) {
        if (message instanceof TextMessage){
             TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("TopicListener 2 message: " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
