package org.fightteam.join.auth.service;

import org.fightteam.join.auth.data.models.Operation;
import org.fightteam.join.auth.data.models.Permission;
import org.fightteam.join.auth.data.models.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 权限业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
public interface PermissionService {

    /**
     * 获取所有权限
     *
     * @return
     */
    List<Permission> findPermissions();

    /**
     * 增加权限
     *
     * @param permission
     * @param operation
     * @param resource
     */
    void addPermission(Permission permission, Operation operation, Resource resource);
}
