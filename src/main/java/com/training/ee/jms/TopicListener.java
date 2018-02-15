package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

/**
 * Created by yusufyazici on 15/02/2018.
 */

@JMSDestinationDefinitions({
        @JMSDestinationDefinition(
                name = "java:/jms/queue/MyTopic",
                destinationName = "MyTopic",
                interfaceName = "javax.jms.Topic"
        )})
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
            propertyName = "destination",
            propertyValue = "MyTopic"),
        @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Topic"
        )})
public class TopicListener implements MessageListener {

    public void onMessage(Message message) {
        if (message instanceof TextMessage){
             TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("TopicListener message: " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
