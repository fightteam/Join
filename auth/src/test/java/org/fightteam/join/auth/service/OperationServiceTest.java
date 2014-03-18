package org.fightteam.join.auth.service;

import org.fightteam.join.auth.SpringTest;
import org.fightteam.join.auth.data.models.Operation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class OperationServiceTest extends SpringTest{

    @Autowired
    private OperationService operationService;

    @Test
    public void testAdd() throws Exception {
        Operation operation = new Operation();
        operation.setEnable(true);
        operation.setName("GET");
        operationService.add(operation);
    }
}
