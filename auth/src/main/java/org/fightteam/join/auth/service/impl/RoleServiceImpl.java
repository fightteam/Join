package org.fightteam.join.auth.service.impl;

import org.fightteam.join.auth.data.RoleRepository;
import org.fightteam.join.auth.data.models.Role;
import org.fightteam.join.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
