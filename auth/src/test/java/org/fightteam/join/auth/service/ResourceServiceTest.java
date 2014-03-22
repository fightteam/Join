package org.fightteam.join.auth.service;

import org.fightteam.join.auth.SpringTest;
import org.fightteam.join.auth.data.models.Resource;
import org.fightteam.join.auth.data.models.ResourceType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class ResourceServiceTest extends SpringTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void testAdd() throws Exception {
        Resource resource = new Resource();
        resource.setEnable(true);
        resource.setResourceType(ResourceType.URL);
        resource.setName("/roles");
        resourceService.add(resource);


    }

}
