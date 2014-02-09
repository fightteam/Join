package org.fightteam.join.samples.filter;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Order(2)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer(){
        super(SecurityApplicationConfig.class);
    }
}
