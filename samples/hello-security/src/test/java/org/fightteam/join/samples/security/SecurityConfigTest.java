package org.fightteam.join.samples.security;

import org.fightteam.join.test.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {TestDataConfig.class})
public class SecurityConfigTest extends AbstractIntegrationTest {

    @Test
    public void init(){
        System.out.println("init");
    }
}
