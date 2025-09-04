package com.gmail.alepekhine.eav.app;

import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import java.util.*;
import lombok.*;

@jakarta.persistence.Entity
@Data
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    // many to one relationship with attribute via value entity
    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Value> values = new ArrayList<>();
}
