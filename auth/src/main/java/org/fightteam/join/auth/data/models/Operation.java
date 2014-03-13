package org.fightteam.join.auth.data.models;

import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 操作
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Operation extends AbstractEntity<Long> {
    private String name;
    private String title;
    private String description;

    private boolean enable = true;
    // 本操作中的权限
    @OneToMany(mappedBy = "operation")
    private List<Permission> permissions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
