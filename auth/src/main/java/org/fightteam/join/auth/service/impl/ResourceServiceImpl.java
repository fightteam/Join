package org.fightteam.join.auth.service.impl;

import org.fightteam.join.auth.data.ResourceRepository;
import org.fightteam.join.auth.data.models.Resource;
import org.fightteam.join.auth.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource add(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public Resource update(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public void delete(Long id) {
        resourceRepository.delete(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Resource findById(Long id) {
        return resourceRepository.findOne(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Resource findByTitle(String title) {
        return resourceRepository.findByTitle(title);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }
}
