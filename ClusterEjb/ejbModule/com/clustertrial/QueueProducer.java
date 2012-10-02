package com.clustertrial;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class QueueProducer implements QueueProducerRemote, QueueProducerLocal {

    @Resource(name = "jms/trialFactory")
    private ConnectionFactory factory;

    @Resource(name = "jms/trialQueue")
    private Destination destination;

    public void publish() {
        System.out.println("Sending message");
        try {
            Connection connection = factory.createConnection();
            try {
                Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
                try {
                    MessageProducer producer = session.createProducer(destination);
                    try {
                        TextMessage message = session.createTextMessage("Hello!");
                        producer.send(message);
                    } finally {
                        producer.close();
                    }
                } finally {
                    session.close();
                }
            } finally {
                connection.close();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
