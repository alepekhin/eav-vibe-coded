-- Entity table
CREATE TABLE IF NOT EXISTS entities  (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Attribute table
CREATE TABLE IF NOT EXISTS attributes  (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Value table
CREATE TABLE IF NOT EXISTS values  (
    id SERIAL PRIMARY KEY,
    entity_id INT REFERENCES entities(id),
    attribute_id INT REFERENCES attributes(id),
    value TEXT NOT NULL -- This can be changed to any valid data type based on your use case.
);
