package org.fightteam.join.auth.service;

import org.fightteam.join.test.DataIntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
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
public class PermissionServiceTest extends DataIntegrationTest{
    @Autowired
    private PermissionService permissionService;


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testGetAllURLResourcePermission() throws Exception {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map =  permissionService.getAllURLResourcePermission();
        System.out.println(map);
    }
}
