package org.fightteam.join.samples.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单测试类
 *
 * @author excalibur
 * @since 0.0.1
 */
public class User {
    private final static Logger log = LoggerFactory.getLogger(User.class);


    public void info() {
        log.info("info test");
    }

    public void debug() {
        log.debug("debug test");
    }
}
