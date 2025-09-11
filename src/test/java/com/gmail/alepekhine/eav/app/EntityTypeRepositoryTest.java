package com.gmail.alepekhine.eav.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.transaction.Transactional;

import java.util.List;

@SpringBootTest
public class EntityTypeRepositoryTest {

    @Autowired
    private EntityTypeRepository repository;

    @Test
    @Transactional
    public void testCRUD() {
        // create
        EntityType target = new EntityType();
        target.setName("test");
        EntityType saved = repository.save(target);
        assertTrue(saved != null);
        assertEquals("test", saved.getName());
        saved.setName("test2");
        // update
        EntityType updated = repository.save(saved);
        assertTrue(updated != null);
        assertEquals("test2", updated.getName());
        // retrieve
        EntityType retrieved = repository.getReferenceById(updated.getId());
        assertEquals("test2", retrieved.getName());
        // find all
        List<EntityType> entityTypes = repository.findAll();
        assertNotNull(entityTypes);
        assertTrue(entityTypes.size() >= 0);
        // delete
        repository.deleteById(retrieved.getId());
        try {
            repository.getReferenceById(updated.getId());
            fail();
        } catch (Exception e1) {
            // ignore
        }

    }

}
