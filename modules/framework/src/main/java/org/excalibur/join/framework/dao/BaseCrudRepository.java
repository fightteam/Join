package org.excalibur.join.framework.dao;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public interface BaseCrudRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
}
