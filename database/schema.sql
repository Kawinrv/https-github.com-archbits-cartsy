CREATE TABLE IF NOT EXISTS categories (
    id SERIAL PRIMARY KEY,
    levels VARCHAR

);

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(255),
    product_s_desc VARCHAR(512),
    product_l_desc TEXT,
    product_actual_price INT DEFAULT 0,
    product_sale_price   DEFAULT 0,
    product_images VARCHAR(255),
    seller_id TEXT,
    quantity INT DEFAULT 0,
    color VARCHAR(255),
    brand VARCHAR(255),
    first_available DATE NOT NULL,
    created_date DATE NOT NULL,
    category_id INT REFERENCES categories(id)
);



CREATE TABLE IF NOT EXISTS sellers (
    id SERIAL PRIMARY KEY,
    seller_name VARCHAR(255),
    seller_tin VARCHAR(255),
    seller_rating VARCHAR(20),
    seller_address VARCHAR,
    seller_phone VARCHAR(20),
    seller_email VARCHAR(255),
    seller_doj DATE NOT NULL,
    seller_status VARCHAR(20),
    seller_profile_pic VARCHAR(255)



);

CREATE TABLE IF NOT EXISTS buyers (
    id SERIAL PRIMARY KEY,
    buyer_name VARCHAR(255),
    buyer_phone VARCHAR(20),
    buyer_email VARCHAR(255),
    buyer_payment_options VARCHAR,
    buyer_addresses VARCHAR,
    buyer_doj DATE NOT NULL,
    buyer_status VARCHAR(20),
    buyer_rating VARCHAR(20),
    buyer_profile_pic VARCHAR(255)

    
);

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    buyer_id INT REFERENCES buyers(id),
    seller_id INT REFERENCES sellers(id),
    product_id INT REFERENCES products(id),
    price INT,
    mode_of_payment VARCHAR(255),
    date_of_order DATE NOT NULL,
    shipping_address VARCHAR,
    date_of_shipment DATE,
    date_of_delivery DATE,
    order_status VARCHAR(255),
    tracking_number VARCHAR(255)


    
);



CREATE TABLE IF NOT EXISTS disputes (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(id)


);

