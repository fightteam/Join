package org.excalibur.join.framework.service.impl;

import org.excalibur.join.framework.service.BaseService;
import org.excalibur.join.framework.core.model.entity.Entity;

import javax.persistence.criteria.Order;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseJpaServiceImpl <T extends Entity, ID extends Serializable>
    extends BaseJpaCrudServiceImpl<T, ID> implements BaseService<T, ID> {




    public Collection<T> findAllByPage(int pageNum, int countPerPage,
                                       Order order) throws Exception {
        // 在子类实现
        return null;
    }

}
