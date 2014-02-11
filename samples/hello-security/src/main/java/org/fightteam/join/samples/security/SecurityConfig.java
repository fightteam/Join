package org.fightteam.join.samples.security;

import org.fightteam.join.samples.security.security.RestAccessDeniedHandler;
import org.fightteam.join.samples.security.security.RestSecurityMetadataSource;
import org.fightteam.join.samples.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.Filter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    UserDetailsService userDetailsService = new UserService();



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
        //auth.userDetailsService(userDetailsService);

    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 主要配置哪里录入信息
     * 以及需要权限的资源等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
//
//        List<AccessDecisionVoter> decisionVoters = new ArrayList<>();
//        // 角色投票器
//        RoleVoter roleVoter = new RoleVoter();
//        decisionVoters.add(roleVoter);
//        // 权限投票器
//        AuthenticatedVoter authenticatedVoter = new AuthenticatedVoter();
//        decisionVoters.add(authenticatedVoter);
//        // web表达式投票器
//        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
//        decisionVoters.add(webExpressionVoter);
//
//        // 决策器 (只要有一个投票器通过就通过)
//        AffirmativeBased affirmativeBased = new AffirmativeBased(decisionVoters);
//
//
//        filterSecurityInterceptor.setSecurityMetadataSource(new RestSecurityMetadataSource());
//        filterSecurityInterceptor.setAccessDecisionManager(affirmativeBased);
//        filterSecurityInterceptor.setAuthenticationManager(authenticationManagerBean());

        http
                .exceptionHandling()
                .accessDeniedHandler(new RestAccessDeniedHandler());

    }

    @Override
    protected UserDetailsService userDetailsService() {

        return userDetailsService;
    }




}
