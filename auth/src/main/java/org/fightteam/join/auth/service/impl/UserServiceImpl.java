package org.fightteam.join.auth.service.impl;

import org.fightteam.join.auth.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务逻辑实现
 *
 * 实现了Spring security的UserDetailsService
 *
 * @author faith
 * @since 0.0.1
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    /**
     * 载入用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException 没有该用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> list = new ArrayList<>();
        System.out.println("**********************************");
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        list.add(grantedAuthority);
        UserDetails userDetails = new User("faith","123456",list);
        return userDetails;
    }
}
