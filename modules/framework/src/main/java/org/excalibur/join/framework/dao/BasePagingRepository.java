package org.excalibur.join.framework.dao;

import org.excalibur.join.framework.core.model.entity.Entity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-29
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 */
public interface BasePagingRepository<T extends Entity, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> {
}
