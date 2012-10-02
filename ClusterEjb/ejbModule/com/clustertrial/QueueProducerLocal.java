package com.clustertrial;

import javax.ejb.Local;

@Local
public interface QueueProducerLocal {

    void publish();

}
