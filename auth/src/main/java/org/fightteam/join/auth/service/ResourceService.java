package org.fightteam.join.auth.service;

import org.fightteam.join.auth.data.models.Resource;

import java.util.List;

/**
 * 资源业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
public interface ResourceService {

    Resource add(Resource resource);

    Resource update(Resource resource);

    void delete(Long id);

    Resource findById(Long id);

    Resource findByTitle(String title);

    List<Resource> findAll();
}
