package org.fightteam.join.samples.token;

import org.fightteam.join.test.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {MvcConfig.class})
public class SpringSecurityTest extends AbstractIntegrationTest {

    @Test
    public void test01() {
        System.out.println("1111");

    }
}
