CREATE TABLE IF NOT EXISTS entity_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS entities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    entity_type_id INTEGER NOT NULL REFERENCES entity_types(id),
    CONSTRAINT fk_entity_type FOREIGN KEY (entity_type_id) REFERENCES entity_types (id)
);

CREATE TABLE IF NOT EXISTS attributes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    entity_type_id INTEGER NOT NULL REFERENCES entity_types(id),
    CONSTRAINT fk_entity_type FOREIGN KEY (entity_type_id) REFERENCES entity_types (id)
);

CREATE TABLE IF NOT EXISTS values (
    id SERIAL PRIMARY KEY,
    value VARCHAR(255) NOT NULL,
    entity_id INTEGER NOT NULL REFERENCES entities(id),
    attribute_id INTEGER NOT NULL REFERENCES attributes(id),
    CONSTRAINT fk_entity FOREIGN KEY (entity_id) REFERENCES entities(id),
    CONSTRAINT fk_attribute FOREIGN KEY (attribute_id) REFERENCES attributes(id)
);

