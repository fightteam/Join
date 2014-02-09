package org.fightteam.join.samples.token.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

import java.util.Collection;
import java.util.List;

/**
 * @author excalibur
 * @since 0.0.1
 */
public class RestAccessDecisionManager extends AbstractAccessDecisionManager {


    public RestAccessDecisionManager(List<AccessDecisionVoter> decisionVoters) {
        super(decisionVoters);
    }

    public RestAccessDecisionManager() {
    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("********************1*******************");
    }
}
