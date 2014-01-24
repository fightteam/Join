package org.fightteam.join.samples.jpa.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
