package org.fightteam.join.samples.token.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 权限资源
 *
 * @author excalibur
 * @since 0.0.1
 */
public class RestSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new HashMap<>();

    {
        RequestMatcher requestMatcher = new AntPathRequestMatcher("/**", null);
        Set<ConfigAttribute> configAttributes = new HashSet<>();
        ConfigAttribute configAttribute = new SecurityConfig("ADMIN");
        configAttributes.add(configAttribute);
        requestMap.put(requestMatcher, configAttributes);
    }

    /**
     * 权限定义
     *
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        System.out.println("********************2*******************");
        System.out.println("object = [" + object + "]");
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        System.out.println("request = [" + request + "]");
        System.out.println(request.getContextPath());
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
        return null;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        System.out.println("********************3*******************");
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }

        return allAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
