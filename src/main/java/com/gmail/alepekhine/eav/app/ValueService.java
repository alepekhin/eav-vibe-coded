package com.gmail.alepekhine.eav.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ValueService {
    private final ValueRepository valueRepository;
    private final EntityRepository entityRepository;
    private final AttributeRepository attributeRepository;

    @Autowired
    public ValueService(EntityRepository entityRepository, AttributeRepository attributeRepository, ValueRepository valueRepository) {
        this.entityRepository = entityRepository;
        this.attributeRepository = attributeRepository;
        this.valueRepository = valueRepository;
    }

    public List<Value> getAll() {
        return valueRepository.findAll();
    }

    public Value getValueById(Long id) {
        return valueRepository.getReferenceById(id);
    }

    public Value createValue(Value value) {
        return valueRepository.save(value);
    }

    public Value updateValue(Value value) {
        return valueRepository.save(value);
    }

    public void deleteValueById(Long id) {
        valueRepository.deleteById(id);
    }
}

