package org.fightteam.join.samples.rest.data.entity;

import org.fightteam.join.dao.entity.AbstractEntity;
import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 角色
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Role extends AbstractEntity<Long> {
    // 用于系统使用
    @Description(value = "a name title")
    @NotNull
    private String name;
    // 用于呈现
    @NotNull
    private String title;
    private String description;
    private boolean enable = true;
    // 角色中的用户
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();


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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
