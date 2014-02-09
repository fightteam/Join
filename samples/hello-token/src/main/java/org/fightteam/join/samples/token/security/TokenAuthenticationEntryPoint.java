package org.fightteam.join.samples.token.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 接入点
 *
 * 当有权限异常会进入该方法
 *
 * @author excalibur
 * @since 0.0.1
 */
public class TokenAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.addHeader("Access-Control-Allow-Origin", "null");
        response.addHeader("WWW-Authenticate", "Basic realm=\"faith\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status " + HttpServletResponse.SC_UNAUTHORIZED + " - " + authException.getMessage());


    }
}
