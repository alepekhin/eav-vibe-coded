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

    public EntityType findById(Long id) {
        return repository.getReferenceById(id);
    }

    public EntityType save(EntityType entityType) {
        return repository.save(entityType);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

