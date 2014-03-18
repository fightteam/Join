package org.fightteam.join.auth.service.impl;

import org.fightteam.join.auth.data.PermissionRepository;
import org.fightteam.join.auth.data.ResourceRepository;
import org.fightteam.join.auth.data.models.*;
import org.fightteam.join.auth.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 权限业务逻辑实现
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    private static final Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ResourceRepository resourceRepository;

//    @Override
//    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getAllURLResourcePermission() {
//        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<>();
//        // 获取所有权限
//        Iterable<Permission> permissions = permissionRepository.findAll();
//
//        for (Permission permission : permissions) {
//            // 获取该权限的操作
//            Operation operation = permission.getOperation();
//            // 获取该权限的资源
//            Resource resource = permission.getResource();
//            // 构造拦截路径
//            RequestMatcher requestMatcher = null;
//            String URL = resource.getName();
//            String method = operation.getName();
//            // 判断是否是正则
//            if (URL.indexOf("^") == 0 || URL.charAt(URL.length()) == '$') {
//                requestMatcher = new RegexRequestMatcher(URL, method);
//            } else {
//                requestMatcher = new AntPathRequestMatcher(URL, method);
//            }
//            // 获取构造路径中权限，有可能没有
//            Collection<ConfigAttribute> configAttributes = map.get(requestMatcher);
//            if (configAttributes == null) {
//                configAttributes = new ArrayList<>();
//            }
//            ConfigAttribute configAttribute = null;
//            // 构造权限
//            configAttribute = new SecurityConfig(permission.getName());
//            configAttributes.add(configAttribute);
//            // 获取该权限的权限组
//            PermissionGroup permissionGroup = permission.getPermissionGroup();
//            if (permissionGroup != null) {
//                configAttribute = new SecurityConfig(permissionGroup.getName());
//                configAttributes.add(configAttribute);
//                // 构造父类
//                PermissionGroup parent = permissionGroup.getParent();
//                if (parent != null) {
//                    configAttribute = new SecurityConfig(parent.getName());
//                    configAttributes.add(configAttribute);
//                }
//            }
//
//            // 获取该权限的角色
//            List<Role> roles = permission.getRoles();
//            for (Role role : roles) {
//                // 构造角色权限
//                configAttribute = new SecurityConfig(role.getName());
//                configAttributes.add(configAttribute);
//                // 构造角色组
//                RoleGroup roleGroup = role.getRoleGroup();
//                if (roleGroup != null) {
//                    configAttribute = new SecurityConfig(roleGroup.getName());
//                    configAttributes.add(configAttribute);
//                    // 构造父类
//                    RoleGroup parent = roleGroup.getParent();
//                    if (parent != null) {
//                        configAttribute = new SecurityConfig(parent.getName());
//                        configAttributes.add(configAttribute);
//                    }
//                }
//
//            }
//
//            map.put(requestMatcher, configAttributes);
//        }
//
//
//        return map;
//    }


    @Override
    public List<Permission> findPermissions() {
        return null;
    }

    @Override
    public void addPermission(Permission permission, Operation operation, Resource resource) {
        permission.setOperation(operation);
        permission.setResource(resource);
        permissionRepository.save(permission);
    }
}
