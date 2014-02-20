package org.fightteam.join.auth.service.impl;

import org.fightteam.join.auth.data.PermissionRepository;
import org.fightteam.join.auth.data.ResourceRepository;
import org.fightteam.join.auth.data.models.Operation;
import org.fightteam.join.auth.data.models.Permission;
import org.fightteam.join.auth.data.models.Resource;
import org.fightteam.join.auth.data.models.ResourceType;
import org.fightteam.join.auth.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class PermissionServiceImpl implements PermissionService {
    private static final Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getAllURLResourcePermission() {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<>();

        List<Permission> permissions = permissionRepository.findAll();
        for(Permission permission:permissions){
            Operation operation = permission.getOperation();
            Resource resource = permission.getResource();
            RequestMatcher requestMatcher = null;
            String URL = resource.getName();
            String method = operation.getName();
            if (URL.indexOf("^") == 0 || URL.charAt(URL.length()) == '$'){
                requestMatcher = new RegexRequestMatcher(URL, method);
            }else{
                requestMatcher = new AntPathRequestMatcher(URL, method);
            }
            Collection<ConfigAttribute> configAttributes = map.get(requestMatcher);
            if (configAttributes == null){
                configAttributes = new ArrayList<>();
            }
            ConfigAttribute configAttribute = new SecurityConfig(permission.getName());
            configAttributes.add(configAttribute);
            map.put(requestMatcher, configAttributes);
        }
        // 构造角色权限

        return map;
    }


//    private Collection<ConfigAttribute> buildURLPermission(List<Resource> resources, List<Operation> operations){
//
//    }
}
