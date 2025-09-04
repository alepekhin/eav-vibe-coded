package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ValueService {

    @Autowired
    private final ValueRepository valueRepository;

    public ValueService(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    // Save operation
    public Value saveValue(Value value) {
        return valueRepository.save(value);
    }

    // Get all entities operation
    public List<Value> getAllEntities() {
        return (List<Value>) valueRepository.findAll();
    }

    // Get by id operation
    public Value getById(Long id) {
        return valueRepository.findById(id).orElseThrow(() -> new IllegalStateException("Value not found with id: " + id));
    }

    // Delete operation
    public void deleteById(Long id) {
        valueRepository.deleteById(id);
    }

}

