package org.excalibur.join.framework.dao;

import org.excalibur.join.framework.core.model.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public interface BaseJpaRepository<T extends Entity, ID extends Serializable>
        extends JpaRepository<T, ID> {
}
