package org.fightteam.join.auth.service;

import org.fightteam.join.auth.SpringTest;
import org.fightteam.join.auth.data.models.Permission;
import org.fightteam.join.auth.data.models.User;
import org.fightteam.join.test.DataIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class UserServiceTest extends SpringTest {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        User user = new User();
        user.setUsername("faith");
        user.setPassword("123456");
        user.setName("刘真源");
        Permission permission = new Permission();
        permission.setId(3L);
        List<Permission> permissions = Arrays.asList(permission);
        user.setPermissions(permissions);

        userService.registerUser(user);
    }
}
