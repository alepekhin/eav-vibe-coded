package com.gmail.alepekhine.eav.app;

import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import java.util.*;
import lombok.*;

@jakarta.persistence.Entity
@Data
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value; // This can be changed to any valid data type based on your use case.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id")
    private Entity entity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;
}
