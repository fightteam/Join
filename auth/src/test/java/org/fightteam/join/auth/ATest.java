package org.fightteam.join.auth;

import org.fightteam.join.auth.service.PermissionService;
import org.fightteam.join.test.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {TestDataConfig.class})
public class ATest extends AbstractIntegrationTest {

    @Autowired
    private PermissionService permissionService;


    @Test
    public void test01(){
        System.out.println(permissionService.getAllURLResourcePermission());
    }
}
