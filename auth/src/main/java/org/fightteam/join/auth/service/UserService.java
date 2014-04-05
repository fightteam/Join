package org.fightteam.join.auth.service;

import org.fightteam.join.auth.data.models.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 用户业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
@RepositoryRestResource(exported = false)
public interface UserService {

    boolean isUsernameExists(String username);

    boolean isEmailExists(String email);

    User registerUser(User user);
}
