package org.fightteam.join.samples.token;

import org.fightteam.join.samples.token.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 主要配置哪里载入用户信息
     * 包括信息的验证方式等等
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中创建一个用户
//        常用数据库来保持用户

        auth.userDetailsService(new UserDetailsServiceImpl());
    }


    /**
     * 主要配置哪里录入信息
     * 以及需要权限的资源等
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
        digestAuthenticationFilter.setUserDetailsService(new UserDetailsServiceImpl());


        UserCache userCache = new NullUserCache();
        digestAuthenticationFilter.setUserCache(userCache);


        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setSecurityMetadataSource(new RestSecurityMetadataSource());
        filterSecurityInterceptor.setAccessDecisionManager(new RestAccessDecisionManager());
        filterSecurityInterceptor.setAuthenticationManager(this.authenticationManagerBean());


        http.httpBasic()
                .and()
        .addFilterAfter(digestAuthenticationFilter, BasicAuthenticationFilter.class)
        .exceptionHandling().authenticationEntryPoint(digestAuthenticationEntryPoint)
            .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
        .authorizeRequests().antMatchers("/**").hasRole("ADMIN").and()
        .addFilterBefore(filterSecurityInterceptor, FilterSecurityInterceptor.class);

    }


}
