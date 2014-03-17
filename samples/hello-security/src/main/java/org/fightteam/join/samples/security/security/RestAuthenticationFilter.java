package org.fightteam.join.samples.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author excalibur
 * @since 0.0.1
 */
public class RestAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private boolean postOnly = true;

    //登录URL
    public RestAuthenticationFilter() {
        super("/login");
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        System.out.println("************************************");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Authentication token was either missing or invalid.");
        return null;
    }
}
