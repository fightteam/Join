package org.fightteam.join.auth.data;

import org.fightteam.join.auth.data.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@RestResource(rel = "operations")
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
