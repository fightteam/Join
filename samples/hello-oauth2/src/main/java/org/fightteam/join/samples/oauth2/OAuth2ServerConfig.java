/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fightteam.join.samples.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity.IgnoredRequestConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author Rob Winch
 */
@Configuration
@Order(3)
public class OAuth2ServerConfig extends WebSecurityConfigurerAdapter {

    private static final String SPARKLR_RESOURCE_ID = "sparklr";

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(WebSecurity builder) throws Exception {
        IgnoredRequestConfigurer ignoring = builder.ignoring();
        ignoring.antMatchers("/oauth/uncache_approvals", "/oauth/cache_approvals");
    }


}
