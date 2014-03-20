package org.fightteam.join.samples.security;

import org.fightteam.join.auth.config.HttpBasicSecurityConfig;
import org.fightteam.join.auth.data.models.*;
import org.fightteam.join.auth.service.PermissionService;
import org.fightteam.join.auth.service.ResourceService;
import org.fightteam.join.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.MatcherType;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import java.util.List;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;
    /**
     * 主要配置哪里载入用户信息
     * 包括信息的验证方式等等
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中创建一个用户
//        常用数据库来保持用户
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        auth.authenticationProvider(provider);
    }




    /**
     * 主要配置哪里录入信息
     * 以及需要权限的资源等
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setRealmName("Contacts Realm via Digest Authentication");
        digestAuthenticationEntryPoint.setKey("acegi");
        digestAuthenticationEntryPoint.setNonceValiditySeconds(10);

        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
        digestAuthenticationFilter.setUserDetailsService(userDetailsService);


        UserCache userCache = new NullUserCache();
        digestAuthenticationFilter.setUserCache(userCache);


        http.httpBasic()
                .and()
                .addFilterAfter(digestAuthenticationFilter, BasicAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(digestAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        List<Permission> permissions = permissionService.findAll();

        List<Role> roles = roleService.findAll();

        List<Resource> resources = resourceService.findAll();

        for(Resource resource:resources){
            //MatcherType.
            //http.authorizeRequests().requestMatchers(resource.getName()).hasAuthority("a");
        }
        for (Permission permission:permissions){
            Resource resource = permission.getResource();
            Operation operation = permission.getOperation();

            if (resource.getResourceType() == ResourceType.URL){
                if (resource.getMatcherType() == MatcherType.ant){
                    //if (permission.getName())
                    http.authorizeRequests().antMatchers(HttpMethod.valueOf(operation.getName()), resource.getName()).access(permission.getName());
                }else if (resource.getMatcherType() == MatcherType.regex){
                    http.authorizeRequests().antMatchers(HttpMethod.valueOf(operation.getName()), resource.getName()).access(permission.getName());
                }else if (resource.getMatcherType() == MatcherType.ciRegex){
                    RegexRequestMatcher regex = new RegexRequestMatcher(resource.getName(), operation.getName(), true);
                    http.authorizeRequests().requestMatchers(regex).access(permission.getName());
                }
            }
        }
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        List<Resource> resources = resourceService.findAll();

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
