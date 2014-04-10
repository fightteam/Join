package org.fightteam.join.dao.data;

import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Table(name = "t_role")
public class Role extends AbstractEntity<Long> {

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
