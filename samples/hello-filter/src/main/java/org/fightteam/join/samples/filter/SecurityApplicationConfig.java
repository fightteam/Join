package org.fightteam.join.samples.filter;

import org.fightteam.join.samples.filter.security.CORSAwareFilter;
import org.fightteam.join.samples.filter.security.RestUserDetailsService;
import org.fightteam.join.samples.filter.test.NullSecurityContextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.error.DefaultOAuth2ExceptionRenderer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.Filter;
import java.util.*;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
public class SecurityApplicationConfig {

    /**
     * 代理过滤器
     *
     * 具体实现由过滤链来完成
     *
     * 如果有多个过滤链就在这定义
     * @return
     */
    @Bean(name = "springSecurityFilterChain")
    public FilterChainProxy portalFilterChainProxy() {

        List<SecurityFilterChain> securityFilterChains = new ArrayList<SecurityFilterChain>();

        //只需要过滤 REST服务的
        securityFilterChains.add(restSecurityFilterChain());

        FilterChainProxy filterChainProxy = new FilterChainProxy(securityFilterChains);
        return filterChainProxy;

    }

    /**
     * 过滤链
     *
     * 根据自己的需要定义出一个过滤链
     *
     * 最好参照官方的默认实现
     *
     * @return
     */
    @Bean
    public SecurityFilterChain restSecurityFilterChain() {
        // 过滤链的路径
        RequestMatcher requestMatcher = new AntPathRequestMatcher("/**");

        // 过滤链
        List<Filter> filters = new ArrayList<Filter>();

        // 根据顺序和需要功能添加过滤器


        // 1.ChannelProcessingFilter
        // 协议过滤器,用于协议之间的切换
//        filters.add(channelProcessingFilter());
        //filters.add(new CORSAwareFilter());

        // 2.SecurityContextPersistenceFilter 必须
        // 权限上下文持久化过滤器,常见是把SecurityContext信息对应到session中
        filters.add(securityContextPersistenceFilter());

        // 3.ConcurrentSessionFilter
        // SecurityContextHolder中更新SessionRegistry，以反映当前的请求中对应的principal
       // filters.add(securityContextHolderAwareRequestFilter());

        // 4.UsernamePasswordAuthenticationFilter, CasAuthenticationFilter, BasicAuthenticationFilter etc
        // 认证方式过滤器，选择其中需要的就
        // filters.add(tokenAuthenticationFilter());
        BasicAuthenticationFilter basicAuthenticationFilter = new BasicAuthenticationFilter(authenticationManager(),
                oauthProcessingFilterEntryPoint());

        filters.add(basicAuthenticationFilter);

        // 5.SecurityContextHolderAwareRequestFilter
        // 注入过滤器，如果你要在HttpServletRequestWrapper中使用，就要配置
        //filters.add(securityContextHolderAwareRequestFilter());

        // 6.JaasApiIntegrationFilter
        // 如果JaasAuthenticationToken在SecurityContextHolder中，Subject将会在JaasAuthenticationToken中贯穿整个过滤链



        // 7.RememberMeAuthenticationFilter
        // 提供“记住我”功能的过滤器

        // 8.AnonymousAuthenticationFilter
        // 提供匿名登录的过滤器

        // 9.ExceptionTranslationFilter
        // 异常处理过滤器
        filters.add(exceptionTranslationFilter());
        // 10.FilterSecurityInterceptor 必须
        // 当需要保护时候，切入点
        filters.add(filterSecurityInterceptor());

        return new DefaultSecurityFilterChain(requestMatcher, filters);
    }

    /**
     * 协议过滤器
     *
     * 常见协议:http、https等
     *
     * @return
     */
//    @Bean
//    public ChannelProcessingFilter channelProcessingFilter(){
//        ChannelProcessingFilter channelProcessingFilter = new ChannelProcessingFilter();
//
//        return channelProcessingFilter;
//    }
    @Bean
    public SecurityContextPersistenceFilter securityContextPersistenceFilter() {

        SecurityContextPersistenceFilter filter = new SecurityContextPersistenceFilter();
        return filter;
    }

    @Bean
    public SecurityContextHolderAwareRequestFilter securityContextHolderAwareRequestFilter() {
        SecurityContextHolderAwareRequestFilter f = new SecurityContextHolderAwareRequestFilter();


        return f;
    }

//    public AbstractAuthenticationProcessingFilter tokenAuthenticationFilter(){
//        Authentication
//    }
    /**
     * 权限接入
     *
     * 必须
     *
     * 自定义权限，权限载入等等都由这关联
     * @return
     */
    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor() {


        FilterSecurityInterceptor f = new FilterSecurityInterceptor();
        f.setAccessDecisionManager(accessDecisionManager());
        f.setAuthenticationManager(authenticationManager());
        f.setSecurityMetadataSource(filterInvocationSecurityMetadataSource());

        try {
            f.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    /**
     * 资源管理
     *
     * @return
     */
    @Bean
    public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource() {

        SecurityExpressionHandler<FilterInvocation> securityExpressionHandler = new DefaultWebSecurityExpressionHandler();

        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        map.put(new AntPathRequestMatcher("/**"), Arrays.<ConfigAttribute>asList(new SecurityConfig("hasRole('ROLE_SUPER')")));

        ExpressionBasedFilterInvocationSecurityMetadataSource ms = new ExpressionBasedFilterInvocationSecurityMetadataSource(map, securityExpressionHandler);

        return ms;
    }

    /**
     *
     * @return
     */
    @Bean
    public AuthenticationManager authenticationManager() {

        List<AuthenticationProvider> providers = new ArrayList<>();

        //PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken();
//        DaoAuthenticationProvider daoAP = new DaoAuthenticationProvider();
//        daoAP.setUserDetailsService(userDetailsService());
//        providers.add(daoAP);
        OAuth2AuthenticationManager manager = new OAuth2AuthenticationManager();
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        InMemoryTokenStore tokenStore = new InMemoryTokenStore();
        DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken("1111");
        //OAuth2Authentication authentication = new
        //tokenStore.storeAccessToken(token, );
        tokenServices.setTokenStore(tokenStore);
        manager.setTokenServices(tokenServices);

        return manager;
    }

    @Bean
    public OAuth2AuthenticationProcessingFilter oauthFilter() {
        OAuth2AuthenticationProcessingFilter filter = new OAuth2AuthenticationProcessingFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationEntryPoint(oauthProcessingFilterEntryPoint());

        return filter;
    }


    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
        p.setUserDetailsService(userDetailsService());
        return p;

    }
    @Bean
    public UserDetailsService userDetailsService() {

        return new RestUserDetailsService();
    }
    /**
     *
     * @return
     */
    @Bean
    public AccessDecisionManager accessDecisionManager() {

        List<AccessDecisionVoter> voters = new ArrayList<>();
        voters.add(new RoleVoter());
        voters.add(new WebExpressionVoter());
        voters.add(new AuthenticatedVoter());

        AffirmativeBased adm = new AffirmativeBased(voters);

        return adm;

    }

    /**
     * 异常处理
     * @return
     */
    @Bean
    public ExceptionTranslationFilter exceptionTranslationFilter() {
        ExceptionTranslationFilter exceptionTranslationFilter = new ExceptionTranslationFilter(oauthProcessingFilterEntryPoint());
        return exceptionTranslationFilter;
    }

    /**
     * 异常切入点
     *
     * 设置了json转换，使用spring mvc的默认实现
     * @return
     */
    @Bean
    public OAuth2AuthenticationEntryPoint oauthProcessingFilterEntryPoint() {
        OAuth2AuthenticationEntryPoint bean = new OAuth2AuthenticationEntryPoint();
        DefaultOAuth2ExceptionRenderer renderer = new DefaultOAuth2ExceptionRenderer();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(converter);
        renderer.setMessageConverters(messageConverters);
        bean.setExceptionRenderer(renderer);
        return bean;
    }
}
