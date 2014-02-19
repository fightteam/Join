package org.fightteam.join.samples.rest.data;

import org.fightteam.join.samples.rest.data.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
