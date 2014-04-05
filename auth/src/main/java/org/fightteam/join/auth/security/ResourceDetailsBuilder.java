package org.fightteam.join.auth.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * 权限资源构造类
 *
 * 该类支持基于特定类型的权限构建资源，该资源用来支持系统权限拦截
 *
 * @author faith
 * @since 0.0.1
 */
public class ResourceDetailsBuilder {

    /**
     * 禁用构造反法禁止实例化该对象
     */
    private ResourceDetailsBuilder() {

    }


    /**
     * 简单URL资源构建方法
     *
     * @param map
     * @return
     */
    public static FilterInvocationSecurityMetadataSource createUrlSource(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map) {
        SecurityExpressionHandler<FilterInvocation> securityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        ExpressionBasedFilterInvocationSecurityMetadataSource ms = new ExpressionBasedFilterInvocationSecurityMetadataSource(map, securityExpressionHandler);
        return ms;
    }

    public void createMethodSource() {

    }


}
