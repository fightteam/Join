package org.fightteam.join.samples.security.web;

import org.fightteam.join.auth.data.models.Operation;
import org.fightteam.join.auth.data.models.Resource;
import org.fightteam.join.auth.service.*;
import org.fightteam.join.samples.security.security.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @Autowired
    private OperationService operationService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private User2Service user2Service;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users() {
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String usersPOST() {
        return "users";
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String roles() {
        return "roles";
    }
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public String rolesPOST() {
        return "roles";
    }

    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public String permissions() {


        return "permissions";
    }

    @RequestMapping(value = "/permissions", method = RequestMethod.POST)
    public String permissionsPOST() {

        configurableApplicationContext.refresh();
        return "permissions";
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public String resources() {
        return "resources";
    }

    @RequestMapping(value = "/resources", method = RequestMethod.POST)
    public String resourcesPOST(String name) {
        Resource resource = new Resource();
        resource.setName(name);

        resourceService.add(resource);
        return "resources";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String operations() {
        user2Service.add("aaaaaa");
        return "operations";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.POST)
    public String operationsPOST(String name) {
        Operation operation = new Operation();
        operation.setName(name);
        operationService.add(operation);
        return "operations";
    }


}
