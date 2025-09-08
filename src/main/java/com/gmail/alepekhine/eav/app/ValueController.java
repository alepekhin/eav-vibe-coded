package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;
import org.springframework.http.HttpStatus;

/*
Create SpringBoot service and controller for CRUD operations with repository
public interface ValueRepository extends JpaRepository<Value, Long> {}
*/
//
// Tested as
// curl -d '{"value":"Август Линус", "entity": {"id":1}, "attribute":{"id":1}}' -H 'Content-Type: application/json' localhost:8080/api/values
//
@RestController
@RequestMapping("/api/values")
public class ValueController {

    private final ValueService valueService;

    @Autowired
    public ValueController(ValueService valueService) {
        this.valueService = valueService;
    }

    // Create a new value
    @PostMapping
    public ResponseEntity<Value> save(@RequestBody Value value) {
        return ResponseEntity.ok(valueService.save(value));
    }

    // Get all values
    @GetMapping
    public List<Value> getAll() {
        return valueService.getAll();
    }

    // Get a value by id
    @GetMapping("/{id}")
    public ResponseEntity<Value> findById(@PathVariable Long id) {
        return ResponseEntity.ok(valueService.findById(id));
    }

    // Delete a value by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        valueService.deleteById(id);
    }
}

