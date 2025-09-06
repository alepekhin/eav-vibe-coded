package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntityTypeService {
    private final EntityTypeRepository repository;

    @Autowired
    public EntityTypeService(EntityTypeRepository repository) {
        this.repository = repository;
    }

    public List<EntityType> getAll() {
        return repository.findAll();
    }

    public EntityType getEntityTypeById(Long id) {
        return repository.getReferenceById(id);
    }

    public EntityType createEntityType(String name) {
        EntityType entityType = new EntityType();
        entityType.setName(name);
        return repository.save(entityType);
    }

    public EntityType updateEntityType(EntityType entityType, String name) {
        if (entityType.getId() != 0) {
            entityType.setName(name);
            return repository.save(entityType);
        } else {
            return null;
        }
    }

    public void deleteEntityTypeById(Long id) {
        repository.deleteById(id);
    }
}

