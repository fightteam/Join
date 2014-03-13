package org.fightteam.join.samples.security;

import org.fightteam.join.auth.security.ResourceDetailsBuilder;
import org.fightteam.join.auth.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * spring security 3.2配置
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableWebMvcSecurity
public class AbstractSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserDetailsService userDetailsService;

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
        //auth.userDetailsService(userDetailsService);
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        provider.setPasswordEncoder(passwordEncoder);
        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("getEmail");
        provider.setSaltSource(saltSource);
        auth.authenticationProvider(provider);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
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

        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
        entryPoint.setRealmName("Contacts Realm via Digest Authentication");
        entryPoint.setKey("acgi");
        entryPoint.setNonceValiditySeconds(10);
        digestAuthenticationFilter.setAuthenticationEntryPoint(entryPoint);
        digestAuthenticationFilter.setUserDetailsService(userDetailsService);


        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandlerImpl()).and()
                .httpBasic().authenticationEntryPoint(entryPoint)
                .and()
                .addFilterAfter(digestAuthenticationFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(filterSecurityInterceptor(), FilterSecurityInterceptor.class);

    }

    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor() throws Exception {


        FilterSecurityInterceptor f = new FilterSecurityInterceptor();

        f.setAccessDecisionManager(accessDecisionManager());
        f.setAuthenticationManager(authenticationManagerBean());
        f.setSecurityMetadataSource(filterInvocationSecurityMetadataSource());

        try {
            f.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }


    @Bean
    public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource() {
        return ResourceDetailsBuilder.createUrlSource(permissionService.getAllURLResourcePermission());
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {

        List<AccessDecisionVoter> voters = new ArrayList<>();
        RoleVoter auth = new RoleVoter();
        auth.setRolePrefix("AUTH_");
        voters.add(new RoleVoter());
        voters.add(auth);
        voters.add(new WebExpressionVoter());
        voters.add(new AuthenticatedVoter());

        AffirmativeBased adm = new AffirmativeBased(voters);

        return adm;

    }
}
