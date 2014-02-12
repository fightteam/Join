package org.fightteam.join.samples.security.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class RestSecurityMetadataSource extends DefaultFilterInvocationSecurityMetadataSource {





    public RestSecurityMetadataSource(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
        super(requestMap);
    }
}
