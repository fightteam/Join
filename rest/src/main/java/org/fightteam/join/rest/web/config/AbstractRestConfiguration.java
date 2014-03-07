package org.fightteam.join.rest.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.MediaType;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
public class AbstractRestConfiguration extends RepositoryRestMvcConfiguration {

//    @Override
//    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
//
//    }
}
