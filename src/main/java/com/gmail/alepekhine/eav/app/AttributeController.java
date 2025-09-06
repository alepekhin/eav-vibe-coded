package com.gmail.alepekhine.eav.app;

/*
Create SpringBoot service for CRUD operations with repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {}
 */
// curl -d '{"name":"Author", "entityType":{"id":1}}' -H "Content-Type:application/json" localhost:8080/api/attributes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {
    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    // Create a new attribute
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Attribute attribute) {
        return ResponseEntity.ok(attributeService.create(attribute));
    }

    // Read an existing attribute by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        return ResponseEntity.ok(attributeService.findById(id));
    }
    
    // Update an existing attribute
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Attribute attribute) {
        return ResponseEntity.ok(attributeService.update(attribute));
    }

    // Delete an existing attribute by ID
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Long id) {
        attributeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    // Get a list of all attributes
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(attributeService.getAll());
    }
}

