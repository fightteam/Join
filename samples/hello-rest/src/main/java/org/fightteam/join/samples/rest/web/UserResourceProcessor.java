package org.fightteam.join.samples.rest.web;

import org.fightteam.join.samples.rest.data.entity.User;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
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
        //resource.getContent().setUsername("faith");
        return resource;
    }
}
