package org.fightteam.join.auth.service.impl;

import org.fightteam.join.auth.data.UserRepository;
import org.fightteam.join.auth.data.models.Permission;
import org.fightteam.join.auth.data.models.Role;
import org.fightteam.join.auth.data.models.User;
import org.fightteam.join.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

    @Autowired
    private UserRepository userRepository;
    /**
     * 载入用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException 没有该用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 载入用户信息
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("couldn't find user by username:"+username);
        }
        List<GrantedAuthority> list = new ArrayList<>();
        // 获取权限
        List<Permission> permissions =user.getPermissions();
        for(Permission permission:permissions){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
            list.add(grantedAuthority);
        }
        // 获取角色
        List<Role> roles = user.getRoles();
        for(Role role:roles){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            list.add(grantedAuthority);
        }


        /**
         *    * @param username the username presented to the
         *        <code>DaoAuthenticationProvider</code>
         * @param password the password that should be presented to the
         *        <code>DaoAuthenticationProvider</code>
         * @param enabled set to <code>true</code> if the user is enabled
         * @param accountNonExpired set to <code>true</code> if the account has not
         *        expired
         * @param credentialsNonExpired set to <code>true</code> if the credentials
         *        have not expired
         * @param accountNonLocked set to <code>true</code> if the account is not
         *        locked
         * @param authorities the authorities that should be granted to the caller
         *        if they presented the correct username and password and the user
         *        is enabled. Not null.
         */
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                list);
        return userDetails;
    }
}
