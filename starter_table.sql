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
