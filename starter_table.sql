CREATE TABLE mst_roles (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           created_by VARCHAR(255) NULL,
                           updated_at TIMESTAMP,
                           updated_by VARCHAR(255),
                           is_active BOOLEAN DEFAULT TRUE,
                           is_delete BOOLEAN NOT NULL DEFAULT FALSE,
                           deleted_by VARCHAR(36),
                           deleted_at TIMESTAMP
);

CREATE TABLE mst_users (
                           id SERIAL PRIMARY KEY,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           password VARCHAR(255) NOT NULL,
                           username VARCHAR NOT NULL UNIQUE,
                           role_id INT REFERENCES mst_roles(id) NULL,

                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           created_by VARCHAR(255) NULL,
                           updated_at TIMESTAMP,
                           updated_by VARCHAR(255),
                           is_active BOOLEAN DEFAULT TRUE,
                           is_delete BOOLEAN NOT NULL DEFAULT FALSE,
                           deleted_by VARCHAR(36),
                           deleted_at TIMESTAMP
);

INSERT INTO mst_roles(name) values ('user');
INSERT INTO mst_roles(name) values ('admin');



-- Create sequence for product IDs
CREATE SEQUENCE mst_products_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

-- Create products table
CREATE TABLE mst_products (
                              id INTEGER DEFAULT nextval('mst_products_id_seq') NOT NULL,
                              name VARCHAR(255) NOT NULL,
                              description TEXT,
                              price DECIMAL(19,2) NOT NULL,
                              sku VARCHAR(255) UNIQUE,
                              stock_quantity INTEGER DEFAULT 0,
                              created_by VARCHAR(255),
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_by VARCHAR(255),
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              deleted_at TIMESTAMP,
                              deleted_by VARCHAR(255),
                              is_active BOOLEAN DEFAULT TRUE,
                              is_delete BOOLEAN DEFAULT FALSE,
                              CONSTRAINT pk_mst_products PRIMARY KEY (id)
);

-- Create index on SKU for faster lookups
CREATE INDEX idx_products_sku ON mst_products(sku);
