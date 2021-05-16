CREATE DATABASE watchesdb;
\c watchesdb
CREATE TABLE IF NOT EXISTS watches
(
    watch_id "varchar"(256) NOT NULL,
    watch_name "varchar"(256) NOT NULL,
    unit_price integer NOT NULL,
    quantity_for_discount integer,
    discount_price integer,
    PRIMARY KEY (watch_id),
    CONSTRAINT watch UNIQUE (watch_id)
);

INSERT INTO public.watches(
	watch_id, watch_name, unit_price, quantity_for_discount, discount_price)
	VALUES ('001', 'Rolex', 100.00, 3, 200.00),
	('002', 'Michael Kors', 80.00, 2, 120.00),
	('003', 'Swatch', 50.00, null, null),
	('004', 'Casio', 30.00, null, null);
