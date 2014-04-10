package org.fightteam.join.dao.service;

import org.fightteam.join.dao.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class UserServiceTest extends SpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void test01() throws Exception {

        userService.find();
    }
}
