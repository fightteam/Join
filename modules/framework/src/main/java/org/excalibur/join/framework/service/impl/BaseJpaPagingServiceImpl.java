package org.excalibur.join.framework.service.impl;

import org.excalibur.join.framework.core.model.entity.Entity;
import org.excalibur.join.framework.service.BaseJpaPagingService;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-29
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseJpaPagingServiceImpl <T extends Entity, ID extends Serializable>
        extends BaseJpaCrudServiceImpl<T, ID> implements BaseJpaPagingService<T, ID> {
        protected BaseJpaPagingService<T, ID> baseJpaCrudRepository;

}
