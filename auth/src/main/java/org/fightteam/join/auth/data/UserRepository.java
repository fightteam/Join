package org.fightteam.join.auth.data;

import org.fightteam.join.auth.data.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@RestResource(rel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
