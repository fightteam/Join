package org.excalibur.join.framework.service;

import org.excalibur.join.framework.validation.Validity;
import org.excalibur.join.framework.core.model.entity.Entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:18
 * 最基本的service接口
 * 支持CRUD
 */
public interface BaseCrudService<T extends Entity, ID extends Serializable> {

    /**
     * 初始化方法 设置一些必要的数据
     */
    public void setupService();

    /**
     * 增加一个对象
     *
     * @param object
     *            新的对象
     */
    public T insert(T object) throws Exception;

    /**
     * 更新一个存在的对象
     *
     * @param object
     *            存在的对象
     */
    public T update(T object) throws Exception;

    /**
     * 删除一个存在的对象
     *
     * @param object
     *            存在的对象
     */
    public void delete(T object) throws Exception;

    /**
     * 根据id查找一个对象
     *
     * @param id
     *            要查找对象的id
     */
    public T findById(ID id) throws Exception;

    /**
     * 验证实体类 注解的属性
     *
     * @param object
     *
     * @return
     */
    public Validity validate(T object);

}
