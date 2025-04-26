CREATE TABLE customers
(
	customer_id SERIAL PRIMARY KEY,
	full_name VARCHAR(255),
	email VARCHAR(255) UNIQUE NOT NULL,
	phone_number NUMERIC(10,0),
	address TEXT
);
