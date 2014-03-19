package org.fightteam.join.auth.data;

import org.fightteam.join.auth.data.models.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {
}
