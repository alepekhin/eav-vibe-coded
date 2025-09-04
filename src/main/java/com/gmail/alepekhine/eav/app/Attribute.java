package com.gmail.alepekhine.eav.app;

import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.CascadeType;
import java.util.*;
import lombok.*;

@jakarta.persistence.Entity
@Data
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One to many relationship with Entity via Value entity
    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Value> values = new ArrayList<>();
}
