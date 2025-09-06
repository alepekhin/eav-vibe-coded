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
    public ResponseEntity<Value> createValue(@RequestBody Value value) {
        Value createdValue = valueService.createValue(value);
        return new ResponseEntity<>(createdValue, HttpStatus.CREATED);
    }

    // Get all values
    @GetMapping
    public List<Value> getAllValues() {
        return valueService.getAll();
    }

    // Get a value by id
    @GetMapping("/{id}")
    public ResponseEntity<Value> getValueById(@PathVariable Long id) {
        Value value = valueService.getValueById(id);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    // Update an existing value
    @PutMapping("/{id}")
    public ResponseEntity<Value> updateValue(@RequestBody Value value) {
        Value updatedValue = valueService.updateValue(value);
        return new ResponseEntity<>(updatedValue, HttpStatus.OK);
    }

    // Delete a value by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValue(@PathVariable Long id) {
        valueService.deleteValueById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

