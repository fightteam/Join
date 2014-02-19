package org.fightteam.join.auth.data;

import org.fightteam.join.auth.data.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
