package org.fightteam.join.auth.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class DynamicFilterInvocationSecurityMetadataSource extends DefaultFilterInvocationSecurityMetadataSource {
    /**
     * Sets the internal request map from the supplied map. The key elements should be of type {@link org.springframework.security.web.util.matcher.RequestMatcher},
     * which. The path stored in the key will depend on
     * the type of the supplied UrlMatcher.
     *
     * @param requestMap order-preserving map of request definitions to attribute lists
     */
    public DynamicFilterInvocationSecurityMetadataSource(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
        super(requestMap);

    }
}
