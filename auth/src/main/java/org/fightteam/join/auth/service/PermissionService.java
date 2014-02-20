package org.fightteam.join.auth.service;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * 权限业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
public interface PermissionService {

    /**
     * 获取所有URL权限
     *
     * @return
     */
    LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getAllURLResourcePermission();
}
