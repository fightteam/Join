package org.fightteam.join.samples.rest.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class User extends AbstractEntity<Long>{

    @JsonIgnore
    private String username;
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
