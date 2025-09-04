package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AttributeService {
    
    @Autowired
    private final AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    // Save operation
    public Attribute saveAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    // Get all entities operation
    public List<Attribute> getAllEntities() {
        return (List<Attribute>) attributeRepository.findAll();
    }

    // Get by id operation
    public Attribute getById(Long id) {
        return attributeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Attribute not found with id: " + id));
    }

    // Delete operation
    public void deleteById(Long id) {
        attributeRepository.deleteById(id);
    }
}

