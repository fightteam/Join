package org.fightteam.join.log;

import org.junit.Before;
import org.junit.Test;

/**
 * 针对日志做的简单测试
 *
 * @author faith
 * @since 0.0.1
 */
public class LogTest {

    private LogTestHelper logTestHelper;
    @Before
    public void setUp() throws Exception {
        logTestHelper = new LogTestHelper();
    }

    @Test
    public void testInfo(){
        logTestHelper.info();
    }

    @Test
    public void testDebug() throws Exception {
        logTestHelper.debug();
    }
}
