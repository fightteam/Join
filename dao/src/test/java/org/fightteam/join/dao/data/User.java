package org.fightteam.join.dao.data;

import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Table(name = "t_user")
public class User extends AbstractEntity<Long> {

    @OneToMany(mappedBy = "user")
    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
