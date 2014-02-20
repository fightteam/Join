package org.fightteam.join.auth.data;

import org.fightteam.join.auth.data.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String name);
}
