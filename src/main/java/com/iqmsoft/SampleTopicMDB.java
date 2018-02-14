package com.iqmsoft;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(name = "SampleTopicMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = SampleResource.MY_TOPIC),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),})
public class SampleTopicMDB implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(SampleTopicMDB.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            LOGGER.log(Level.INFO, "received: {0}", ((TextMessage) message).getText());
        } catch (JMSException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);

        }
    }

}
