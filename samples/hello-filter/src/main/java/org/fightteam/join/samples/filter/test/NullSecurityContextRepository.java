package org.fightteam.join.samples.filter.test;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

/**
 * @author Luke Taylor
 * @since 3.1
 */
public final class NullSecurityContextRepository implements SecurityContextRepository {

    public boolean containsContext(HttpServletRequest request) {
        return false;
    }

    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        System.out.println("*********************************************");
        return SecurityContextHolder.createEmptyContext();
    }

    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
    }

}
