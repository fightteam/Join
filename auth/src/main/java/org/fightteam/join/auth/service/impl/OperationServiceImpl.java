package org.fightteam.join.auth.service.impl;

import org.fightteam.join.auth.data.OperationRepository;
import org.fightteam.join.auth.data.models.Operation;
import org.fightteam.join.auth.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Operation add(Operation operation) {
        operation = operationRepository.save(operation);
        return operation;
    }

    @Override
    public Operation update(Operation operation) {
        operation = operationRepository.save(operation);
        return operation;
    }

    @Override
    public void delete(Long id) {
        operationRepository.delete(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Operation findById(Long id) {
        return operationRepository.findOne(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Operation findByTitle(String title) {
        return operationRepository.findByTitle(title);
    }
}
