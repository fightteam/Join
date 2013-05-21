package org.excalibur.join.framework.service;


import org.excalibur.join.framework.core.model.entity.Entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-29
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
public interface BaseJpaPagingService <T extends Entity, ID extends Serializable> extends
        BaseCrudService<T, ID>{
}
