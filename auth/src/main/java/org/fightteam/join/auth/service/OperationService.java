package org.fightteam.join.auth.service;

import org.fightteam.join.auth.data.models.Operation;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * 操作业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
public interface OperationService {
    @PreAuthorize("hasAuthority('ROLE_TELLER')")
    Operation add(Operation operation);

    Operation update(Operation operation);

    void delete(Long id);

    Operation findById(Long id);

    Operation findByTitle(String title);
}
