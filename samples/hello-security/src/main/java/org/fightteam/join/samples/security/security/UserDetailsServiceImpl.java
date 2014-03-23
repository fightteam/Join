package org.fightteam.join.samples.security.security;

import org.fightteam.join.auth.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService , User2Service {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("==========loadUserByUsername============");
        System.out.println("username = [" + username + "]");


        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("VIEWUSERS"));

        UserDetails userDetails = new User("faith","123456",
                grantedAuthorities);
        return userDetails;
    }

    @Override
    public void add(String name) {

    }

    @Override
    public void update(int a) {

    }

    @Override
    public void delete(String c) {

    }

    @Override
    public void find(String a) {

    }

    @Override
    public void find(String a, String b) {

    }
}
