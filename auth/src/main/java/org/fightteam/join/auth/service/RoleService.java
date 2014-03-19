package org.fightteam.join.auth.service;

import org.fightteam.join.auth.data.models.Permission;
import org.fightteam.join.auth.data.models.Role;

import java.util.List;

/**
 * 角色业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
public interface RoleService {

    List<Role> findAll();
}
