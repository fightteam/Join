package org.fightteam.join.auth.service;

import org.fightteam.join.auth.SpringTest;
import org.fightteam.join.auth.data.models.Operation;
import org.fightteam.join.auth.data.models.Permission;
import org.fightteam.join.auth.data.models.Resource;
import org.fightteam.join.test.DataIntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class PermissionServiceTest extends SpringTest {

    @Autowired
    private PermissionService permissionService;


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testAddPermission() throws Exception {
        Permission permission = new Permission();
        permission.setName("hasAuthority('VIEWROLES')");
        permission.setEnable(true);



        permissionService.addPermission(permission, 1L, 3L);
    }
}
