package org.fightteam.join.samples.log;

import org.junit.Before;
import org.junit.Test;

/**
 * @author excalibur
 * @since 0.0.1
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void testInfo() throws Exception {
        user.info();
    }

    @Test
    public void testDebug() throws Exception {
        user.debug();

    }
}
