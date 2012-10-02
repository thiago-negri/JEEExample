package com.clustertrial;

import javax.ejb.Remote;

@Remote
public interface QueueProducerRemote {

    void publish();

}
