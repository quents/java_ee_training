package com.training.ee.jms;

import com.training.ee.cdi.PersonState;
import com.training.ee.ejb.PersonDAO;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;

/**
 * Created by yusufyazici on 15/02/2018.
 */



@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "CommunicationTopic"),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "javax.jms.Topic"
        )})
public class TopicListenerSMS implements MessageListener {


    @Inject
    PersonStateCDI personStateCDI;

    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;

            try {
                String uid = (String) textMessage.getText();
                if (uid != null){
                    PersonState personState = personStateCDI.getPersonStateWithUid(uid);
                    try {
                        personState.setSmsState(EState.SUCCESS);
                    } catch (Exception e){
                        personState.setSmsState(EState.FAILURE);
                    }
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
