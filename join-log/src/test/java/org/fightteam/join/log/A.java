package org.fightteam.join.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by faith on 14-1-15.
 */
public class A {
    public static final Logger logger = LoggerFactory.getLogger(A.class);

    public void index(){
        logger.info("in index method");
    }

    public void index1(){
        logger.debug("in index1 method");
    }
}
