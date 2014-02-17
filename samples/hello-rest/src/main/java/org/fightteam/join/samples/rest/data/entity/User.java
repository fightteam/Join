package org.fightteam.join.samples.rest.data.entity;

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

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
