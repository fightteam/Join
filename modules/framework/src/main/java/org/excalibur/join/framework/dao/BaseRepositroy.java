package org.excalibur.join.framework.dao;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public interface BaseRepositroy<T, ID extends Serializable> extends
        Repository<T, ID> {
}
