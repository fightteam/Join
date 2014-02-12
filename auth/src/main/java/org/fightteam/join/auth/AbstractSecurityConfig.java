package org.fightteam.join.auth;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * spring security 3.2配置
 *
 * @author faith
 * @since 0.0.1
 */
@EnableWebMvcSecurity
public class AbstractSecurityConfig extends WebSecurityConfigurerAdapter{

}
