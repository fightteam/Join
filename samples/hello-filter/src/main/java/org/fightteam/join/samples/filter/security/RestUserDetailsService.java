package org.fightteam.join.samples.filter.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author excalibur
 * @since 0.0.1
 */
public class RestUserDetailsService implements UserDetailsService,ClientDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("-----------------------------------");
        System.out.println("username = [" + username + "]");
        List<GrantedAuthority> list = new ArrayList<>();

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        list.add(grantedAuthority);
        UserDetails userDetails = new User("faith","123456",list);
        return userDetails;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        System.out.println("======================================");
        return null;
    }
}
