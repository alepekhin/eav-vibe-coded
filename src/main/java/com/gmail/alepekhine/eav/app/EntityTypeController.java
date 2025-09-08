package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;

/*
Create SpringBoot service and controller for CRUD operations with repository
public interface EntityTypeRepository extends JpaRepository<EntityType, Long> {}
*/
//
// Tested as
// curl -d '{"name":"Book"}' -H 'Content-Type: application/json' localhost:8080/api/entity-types
//
@RestController
@RequestMapping("/api/entity-types")
@CrossOrigin(origins = "http://localhost:4200")
public class EntityTypeController {

    private final EntityTypeService entityTypeService;

    @Autowired
    public EntityTypeController(EntityTypeService entityTypeService) {
        this.entityTypeService = entityTypeService;
    }

    // Method to save an EntityType
    @PostMapping
    public ResponseEntity<EntityType> save(@RequestBody EntityType entityType) {
        EntityType savedEntityType = entityTypeService.save(entityType);
        return ResponseEntity.ok(savedEntityType);
    }

    // Method to get all EntityType
    @GetMapping
    public List<EntityType> getAll() {
        return entityTypeService.getAll();
    }

    // Method to get one EntityType by id
    @GetMapping("/{id}")
    public ResponseEntity<EntityType> findById(@PathVariable Long id) {
        return ResponseEntity.ok(entityTypeService.findById(id));
    }

    // Method to delete an EntityType
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        entityTypeService.deleteById(id);
    }
}

