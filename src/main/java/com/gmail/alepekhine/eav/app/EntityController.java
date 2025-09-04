package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
//
// Tested as
// curl -d '{"name":"My Book"}' -H 'Content-Type: application/json' localhost:8080/api/entities
//
@RestController
@RequestMapping("/api/entities")
public class EntityController {
    
    @Autowired
    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    // Save operation
    @PostMapping
    public ResponseEntity saveEntity(@RequestBody Entity entity) {
        return ResponseEntity.ok().body(this.entityService.saveEntity(entity));
    }
    
    // Get all entities operation
    @GetMapping
    public ResponseEntity getAllEntities() {
        return ResponseEntity.ok().body(entityService.getAllEntities());
    }

    // Get by id operation
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        return ResponseEntity.ok().body(entityService.getById(id));
    } 
    
    // Delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEntity(@PathVariable long id) {
        entityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }      
}
