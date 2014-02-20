package org.fightteam.join.samples.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.error.DefaultOAuth2ExceptionRenderer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * spring security 3.2配置
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableWebMvcSecurity
public class AbstractSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 禁用掉默认的配置
     */
    protected AbstractSecurityConfig() {
        super(true);
    }

    @Autowired
    private UserDetailsService userDetailsService;

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
        auth.userDetailsService(userDetailsService);

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
        http
                .csrf().and()
                .addFilter(new WebAsyncManagerIntegrationFilter())
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler()).and()
                .headers().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .securityContext().and()
                .requestCache().and()
                .anonymous().and()
                .servletApi().and()
                .logout();

        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
        entryPoint.setRealmName("Contacts Realm via Digest Authentication");
        entryPoint.setKey("acgi");
        entryPoint.setNonceValiditySeconds(10);
        digestAuthenticationFilter.setAuthenticationEntryPoint(entryPoint);
        digestAuthenticationFilter.setUserDetailsService(userDetailsService);


        // 403 异常
        OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler = new OAuth2AccessDeniedHandler();
        DefaultOAuth2ExceptionRenderer renderer = new DefaultOAuth2ExceptionRenderer();
        List<HttpMessageConverter<?>> result = new ArrayList<>();
        result.addAll(new RestTemplate().getMessageConverters());
        result.add(new MappingJackson2HttpMessageConverter());
        renderer.setMessageConverters(result);
        oAuth2AccessDeniedHandler.setExceptionRenderer(renderer);

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(oAuth2AccessDeniedHandler).and()
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

        SecurityExpressionHandler<FilterInvocation> securityExpressionHandler = new DefaultWebSecurityExpressionHandler();

        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<>();
        map.put(new AntPathRequestMatcher("/1"), Arrays.<ConfigAttribute>asList(new org.springframework.security.access.SecurityConfig("hasAuthority('AUTH_A@CREATE')")));
        map.put(new AntPathRequestMatcher("/**", HttpMethod.GET.name()), Arrays.<ConfigAttribute>asList(new org.springframework.security.access.SecurityConfig("hasRole('ROLE_ADMIN')")));
        map.put(new AntPathRequestMatcher("/**", HttpMethod.POST.name()), Arrays.<ConfigAttribute>asList(new org.springframework.security.access.SecurityConfig("hasRole('ROLE_ADMIN')")));
        map.put(new AntPathRequestMatcher("/**", HttpMethod.PUT.name()), Arrays.<ConfigAttribute>asList(new org.springframework.security.access.SecurityConfig("hasRole('ROLE_ADMIN')")));
        map.put(new AntPathRequestMatcher("/**", HttpMethod.DELETE.name()), Arrays.<ConfigAttribute>asList(new org.springframework.security.access.SecurityConfig("hasRole('ROLE_ADMIN')")));
        ExpressionBasedFilterInvocationSecurityMetadataSource ms = new ExpressionBasedFilterInvocationSecurityMetadataSource(map, securityExpressionHandler);

        return ms;
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

    public AuthorizationEndpoint authenticationEntryPoint(){
        AuthorizationEndpoint endpoint = new AuthorizationEndpoint();
        //endpoint.afterPropertiesSet();
        return endpoint;
    }
}
