package com.clustertrial;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;

@Singleton
public class ProducerTimer {

    @EJB
    private QueueProducerRemote producer;

    @SuppressWarnings("unused")
    @Schedule(second = "*/10", minute = "*", hour = "*", info = "MyTimer", persistent = true)
    private void scheduledTimeout(Timer timer) {
        System.out.println("Timeout.");
        producer.publish();
    }

}
