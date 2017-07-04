package org.exampledriven.springboottestingworkshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Peter Szanto on 7/4/2017.
 */
@Service
public class BlackBoxService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void doUntestableThings() {
        logger.debug("Secret processing is done");
    }

}
