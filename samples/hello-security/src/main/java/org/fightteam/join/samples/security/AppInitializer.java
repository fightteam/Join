package org.fightteam.join.samples.security;

import org.fightteam.join.AbstractAppConfig;
import org.fightteam.join.auth.AbstractSecurityConfig;
import org.fightteam.join.web.AbstractWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AbstractAppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AbstractWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
