package org.fightteam.join.samples.token;

import org.fightteam.join.test.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.security.access.*;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashSet;
import java.util.Set;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {MvcConfig.class})
public class SpringSecurityTest extends AbstractIntegrationTest {

    @Test
    public void test01(){
        System.out.println("1111");

    }
}
