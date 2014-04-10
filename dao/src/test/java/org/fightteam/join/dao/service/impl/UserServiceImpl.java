package org.fightteam.join.dao.service.impl;

import org.fightteam.join.dao.data.Role;
import org.fightteam.join.dao.data.RoleRepository;
import org.fightteam.join.dao.data.User;
import org.fightteam.join.dao.data.UserRepository;
import org.fightteam.join.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void find() {
        if (userRepository.count() == 0 ){
            User user = new User();

            Role role1 = new Role();
            role1.setUser(user);

            Role role2 = new Role();
            role2.setUser(user);

            userRepository.save(user);

            roleRepository.save(role1);
            roleRepository.save(role2);
        }

        List<User> users = userRepository.findAll();
        for(User user : users){
            List<Role> roles = user.getRoles();
            for(Role role : roles){
                System.out.println(role.getId());
            }
        }
    }
}
