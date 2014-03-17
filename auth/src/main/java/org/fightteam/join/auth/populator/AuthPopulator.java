//package org.fightteam.join.auth.populator;
//
//import org.fightteam.join.auth.data.OperationRepository;
//import org.fightteam.join.auth.data.PermissionRepository;
//import org.fightteam.join.auth.data.ResourceRepository;
//import org.fightteam.join.auth.data.models.Operation;
//import org.fightteam.join.auth.data.models.Permission;
//import org.fightteam.join.auth.data.models.Resource;
//import org.fightteam.join.auth.data.models.ResourceType;
//import org.fightteam.join.auth.service.OperationService;
//import org.fightteam.join.auth.service.PermissionService;
//import org.fightteam.join.auth.service.ResourceService;
//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * 权限数据初始化
// *
// * @author faith
// * @since 0.0.1
// */
//@Component
//@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Transactional
//public class AuthPopulator {
//
////    @Value("${init.on.start}")
//    private boolean initOnStrat = true;
//
//    @Autowired
//    private OperationRepository operationRepository;
//
//    @Autowired
//    private ResourceRepository resourceRepository;
//
//    @Autowired
//    private PermissionRepository permissionRepository;
//
//    @Autowired
//    private PermissionRepository permissionGroupRepository;
//
//    @Autowired
//    private PermissionRepository roleRepository;
//
//    @Autowired
//    private PermissionRepository roleGroupRepository;
//
//    @Autowired
//    private PermissionRepository userRepository;
//
//    public AuthPopulator() {
//        initPermissions();
//    }
//
//    public void initPermissions(){
//        if (!initOnStrat || (operationRepository.count() != 0 && resourceRepository.count() != 0
//                && permissionRepository.count() != 0)){
//            return;
//        }
//        Operation get = new Operation();
//        get.setEnable(true);
//        get.setCreateDate(new DateTime());
//        get.setName("GET");
//        operationRepository.save(get);
//
//        Operation post = new Operation();
//        post.setEnable(true);
//        post.setCreateDate(new DateTime());
//        post.setName("POST");
//        operationRepository.save(post);
//
//        Operation put = new Operation();
//        put.setEnable(true);
//        put.setCreateDate(new DateTime());
//        put.setName("PUT");
//        operationRepository.save(put);
//
//        Operation delete = new Operation();
//        delete.setEnable(true);
//        delete.setCreateDate(new DateTime());
//        delete.setName("DELETE");
//        operationRepository.save(delete);
//
//        Operation patch = new Operation();
//        patch.setEnable(true);
//        patch.setCreateDate(new DateTime());
//        patch.setName("PATCH");
//        operationRepository.save(patch);
//
//        Resource index = new Resource();
//        index.setCreateDate(new DateTime());
//        index.setEnable(true);
//        index.setName("/");
//        index.setType(ResourceType.URL);
//        resourceRepository.save(index);
//
//        Resource login = new Resource();
//        login.setCreateDate(new DateTime());
//        login.setEnable(true);
//        login.setName("/login");
//        login.setType(ResourceType.URL);
//        resourceRepository.save(login);
//
//        Permission viewIndex = new Permission();
//        viewIndex.setEnable(true);
//        viewIndex.setCreateDate(new DateTime());
//        viewIndex.setResource(index);
//        viewIndex.setOperation(get);
//        viewIndex.setName("查看首页");
//        permissionRepository.save(viewIndex);
//
//        Permission viewLogin = new Permission();
//        viewLogin.setEnable(true);
//        viewLogin.setCreateDate(new DateTime());
//        viewLogin.setResource(login);
//        viewLogin.setOperation(get);
//        viewLogin.setName("查看登陆页");
//        permissionRepository.save(viewLogin);
//    }
//
//    public boolean isInitOnStrat() {
//        return initOnStrat;
//    }
//
//    public void setInitOnStrat(boolean initOnStrat) {
//        this.initOnStrat = initOnStrat;
//    }
//}
