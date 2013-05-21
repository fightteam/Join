package org.excalibur.join.framework.service.impl;


import org.excalibur.join.framework.core.model.entity.Entity;
import org.excalibur.join.framework.dao.BaseJpaCrudRepository;
import org.excalibur.join.framework.exception.database.NotFoundException;
import org.excalibur.join.framework.service.BaseCrudService;
import org.excalibur.join.framework.validation.EntityValidator;
import org.excalibur.join.framework.validation.Validity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:21
 * 基础CRUD的实现
 *
 */
public abstract class BaseJpaCrudServiceImpl<T extends Entity, ID extends Serializable>
        implements BaseCrudService<T, ID> {

    protected BaseJpaCrudRepository<T, ID> baseJpaCrudRepository;
    protected Class<T> entityClass;
    protected String nfEntityMsg;
    protected int nfEntityCode;

    public T insert(T object) throws Exception {
        return baseJpaCrudRepository.save(object);
    }

    public T update(T object) throws Exception {
        return baseJpaCrudRepository.save(object);
    }

    public void delete(T object) throws Exception {
        baseJpaCrudRepository.delete(object);
    }

    public T findById(ID id) throws Exception {
        T result = baseJpaCrudRepository.findOne(id);

        if (result != null)
            return result;
        else
            throw new NotFoundException(nfEntityMsg, nfEntityCode);
    }

    public Validity validate(T object) {
        EntityValidator<T> entityValidator = new EntityValidator<T>();
        return entityValidator.validate(object, entityClass);
    }
}
