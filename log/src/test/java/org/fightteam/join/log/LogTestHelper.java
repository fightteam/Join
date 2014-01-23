package org.fightteam.join.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志测试帮助类
 *
 * 针对日志做测试做的一个数据封装
 *
 * @author faith
 * @since 0.0.1
 */
public class LogTestHelper {
    public static final Logger logger = LoggerFactory.getLogger(LogTestHelper.class);


    public void info(){
        logger.info("in info method");
    }

    public void debug(){
        logger.debug("in debug method");
    }
}
