package org.excalibur.join.framework.service;

import org.excalibur.join.framework.core.model.entity.Entity;

import javax.persistence.criteria.Order;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:16
 * 支持分页查询的service接口
 * 继承了CRUD操作
 */
public interface BaseService<T extends Entity, ID extends Serializable> extends BaseCrudService<T, ID>{
    /**
     * 分页查询
     *
     * @param pageNum
     * @param countPerPage
     * @param order
     *
     * @return
     *
     * @throws Exception
     */
    public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) throws Exception;
}
