package org.fightteam.join.auth.service;

import org.fightteam.join.test.DataIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class UserServiceTest extends DataIntegrationTest {
    @Autowired
    private PermissionService permissionService;


    @Test
    public void test01() {
        System.out.println(permissionService.getAllURLResourcePermission());
    }
}
