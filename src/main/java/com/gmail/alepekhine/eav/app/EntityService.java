package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EntityService {
    
    @Autowired
    private final EntityRepository entityRepository;

    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    // Save operation
    public Entity saveEntity(Entity entity) {
        return entityRepository.save(entity);
    }

    // Get all entities operation
    public List<Entity> getAllEntities() {
        return entityRepository.findAll();
    }

    // Get by id operation
    public Entity getById(Long id) {
        return entityRepository.getReferenceById(id);
    }

    // Delete operation
    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }
}

