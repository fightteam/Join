package org.fightteam.join.auth.web.processor;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Component
public class UserResourceProcessor implements ResourceProcessor<Resource<User>> {
    @Override
    public Resource<User> process(Resource<User> resource) {
        User user = resource.getContent();
        // 转换

        return resource;
    }
}
