package org.excalibur.join.framework.core.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * author: excalibur
 * Date: 13-4-27
 * Time: 下午11:22
 * 实体的jpa 抽象实现
 * 定义了一些基础或者常用的属性
 */
@MappedSuperclass
public class JpaEntity <T extends Serializable> implements Entity {
    @Id
    @GeneratedValue
    private T id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public JpaEntity() {
        this.createAt = new Date();
        this.updateAt = new Date();
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
