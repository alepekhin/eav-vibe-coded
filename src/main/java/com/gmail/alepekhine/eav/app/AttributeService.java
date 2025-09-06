package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttributeService {
    private final AttributeRepository attributeRepository;

    @Autowired
    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    // Create a new attribute
    public Attribute create(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    // Read an attribute by ID
    public Attribute findById(Long id) {
        return attributeRepository.getReferenceById(id);
    }

    // Update an existing attribute
    public Attribute update(Attribute attribute) {
        if (attributeRepository.existsById(attribute.getId())) {
            return attributeRepository.save(attribute);
        } else {
            throw new RuntimeException("No attribute with such Id");
        }
    }

    // Delete an attribute by ID
    public void deleteById(Long id) {
        if (attributeRepository.existsById(id)) {
            attributeRepository.deleteById(id);
        } else {
            throw new RuntimeException("No attribute with such Id");
        }
    }

    // Get a list of all attributes
    public List<Attribute> getAll() {
        return attributeRepository.findAll();
    }
}

