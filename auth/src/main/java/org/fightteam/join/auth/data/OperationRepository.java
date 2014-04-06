package org.fightteam.join.auth.data;

import org.fightteam.join.auth.data.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 操作查询
 *
 * @author faith
 * @since 0.0.1
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {

    Operation findByTitle(@Param("title")String title);

    Operation findByName(@Param("name")String name);
}
