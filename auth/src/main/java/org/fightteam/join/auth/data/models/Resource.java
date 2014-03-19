package org.fightteam.join.auth.data.models;

import org.fightteam.join.dao.entity.AbstractEntity;
import org.springframework.security.config.http.MatcherType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 资源
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Resource extends AbstractEntity<Long> {

    private String name;
    private String title;
    private String description;
    private boolean enable = true;
    // 本资源的类型
    @Enumerated
    private ResourceType resourceType;

    @Enumerated
    private MatcherType matcherType;

    // 本资源中的权限
    @OneToMany(mappedBy = "resource")
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

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public MatcherType getMatcherType() {
        return matcherType;
    }

    public void setMatcherType(MatcherType matcherType) {
        this.matcherType = matcherType;
    }
}
