package org.fightteam.join.samples.security.web;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users() {
        return "users";
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String roles() {
        return "roles";
    }

    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public String permissions() {
        return "permissions";
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public String resources() {
        return "resources";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String operations() {
        return "operations";
    }
}
