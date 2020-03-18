DROP TABLE IF EXISTS brands;
CREATE TABLE brands (
	b_id INT AUTO_INCREMENT  PRIMARY KEY,
	brand_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
	c_id INT AUTO_INCREMENT  PRIMARY KEY,
	category_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS sizes;
CREATE TABLE sizes (
	s_id INT AUTO_INCREMENT  PRIMARY KEY,
	size_name VARCHAR(250) NULL
);

/* Pre-joinned denormalized table */
DROP TABLE IF EXISTS products;
CREATE TABLE products (
	p_id INT AUTO_INCREMENT  PRIMARY KEY,
	p_name VARCHAR(250) NOT NULL,
	brand_id INT NOT NULL REFERENCES brands(b_id),
	brand_name VARCHAR(250) NOT NULL,
	category_id INT NOT NULL REFERENCES categories(c_id),
	category_name VARCHAR(250) NOT NULL,
	
	size_id INT NOT NULL REFERENCES sizes(s_id),
	size_name VARCHAR(250) NOT NULL,
	product_sku VARCHAR(250) NOT NULL UNIQUE,
	colour VARCHAR(250) NOT NULL,
	price VARCHAR(250) NOT NULL,
	availble VARCHAR(250) NOT NULL
);

CREATE INDEX brand_id_idx ON products(brand_id);
CREATE INDEX size_id_idx ON products(size_id);
CREATE INDEX product_sku_idx ON products(product_sku);


INSERT INTO brands (
b_id, 
brand_name
) VALUES
(201001, 'Nike'),
(201002, 'BlackBerry');

INSERT INTO categories (
c_id,
category_name
) VALUES
(191001, 'Shoes'),
(191002, 'Shirts');

INSERT INTO sizes (
s_id,
size_name
) VALUES
(151001, '9'),
(151002, '10'),
(151003, 'XL');

INSERT INTO products (
p_id, 
p_name, 
brand_id, 
brand_name, 
category_id, 
category_name,
size_id,
size_name,
product_sku,
colour,
price,
availble) VALUES
(1001, 'Nike Jordans 2020', 201001, 'Nike', 191001, 'shoes', 151001, '9', '1010101010', 'Black', 'Rs 6000', '100'),  
(1002, 'Nike Reos', 201001, 'Nike', 191001, 'shoes', 151002, '10', '1010101067', 'Green', 'Rs 4000', '50');








