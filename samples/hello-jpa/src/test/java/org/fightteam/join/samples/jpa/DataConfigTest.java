package org.fightteam.join.samples.jpa;

import org.fightteam.join.samples.jpa.data.User;
import org.fightteam.join.samples.jpa.data.UserRepository;
import org.fightteam.join.test.AbstractIntegrationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {DataConfig.class})
@TransactionConfiguration
@Transactional
public class DataConfigTest extends AbstractIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    private User user = null;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUsername("excalibur");
    }

    @Test
    public void testSave(){
        userRepository.save(user);
        Assert.assertNotEquals(0,user.getId());
    }

    @Test
    public void testFind(){
        testSave();
        User u = userRepository.findByUsername(user.getUsername());
        Assert.assertNotNull(u);
    }
}
