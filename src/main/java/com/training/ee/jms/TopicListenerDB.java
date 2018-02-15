package com.training.ee.jms;

import com.training.ee.cdi.PersonState;
import com.training.ee.ejb.PersonDAO;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;
import javax.xml.soap.Text;

/**
 * Created by yusufyazici on 15/02/2018.
 */



@JMSDestinationDefinitions({
        @JMSDestinationDefinition(
                name = "java:/jms/queue/CommunicationTopic",
                destinationName = "CommunicationTopic",
                interfaceName = "javax.jms.Topic"
        )})
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "CommunicationTopic"),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "javax.jms.Topic"
        )})
public class TopicListenerDB implements MessageListener {

    @Inject
    PersonDAO personDAO;

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
                        personDAO.save(personState.getPerson());
                        personState.setDbState(EState.SUCCESS);
                    } catch (Exception e){
                        personState.setDbState(EState.FAILURE);
                    }

                }
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }
}
