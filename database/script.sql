CREATE SCHEMA flavour_hub;

USE flavour_hub;

--category table
CREATE TABLE category (
    category_id VARCHAR(255) PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    category_description TEXT NULL,
    category_image_url TEXT NULL,
    food_status ENUM('AVAILABLE','UNAVAILABLE') DEFAULT 'AVAILABLE',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)   
);


--food-item table
CREATE TABLE food_item(
    food_id VARCHAR(255) PRIMARY KEY ,
    category_id VARCHAR(255) NOT NULL,
    food_name VARCHAR(100),
    food_description TEXT NULL,
    price DOUBLE NOT NULL,
    food_item_status ENUM('AVAILABLE','UNAVAILABLE') DEFAULT 'AVAILABLE',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(category_id) REFERENCES category(category_id)

);


--food_category_mapping table
CREATE TABLE food_category_mapping(
    food_category_mapping_id VARCHAR(255) PRIMARY KEY ,
    food_id VARCHAR(255)  NOT NULL,
    category_id VARCHAR(255),
    FOREIGN KEY(category_id) REFERENCES category(category_id),
    FOREIGN KEY(food_id) REFERENCES food_item(food_id)
);



--order table
CREATE TABLE order(
    order_id VARCHAR(255) PRIMARY KEY ,
    user_id INT NOT NULL,
    order_quantity INT NOT NULL CHECK (order_quantity > 0 ),
    total_price DOUBLE NOT NULL,
    order_status enum ('PENDING','CONFIRMED','PREPARING','OUT_FOR_DELIVERY','DELIVERED','CANCELLED') DEFAULT 'PENDING',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(user_id) REFERENCES user(user_id)

);

--order item table
CREATE TABLE order_item(
    order_item_id  VARCHAR(255) PRIMARY KEY ,
    order_id VARCHAR(255) NOT NULL,
    food_id VARCHAR(255) NOT NULL,
    order_item_quantity INT NOT NULL CHECK(quantity >0),
    order_item_price DOUBLE NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(order_id) REFERENCES order(order_id),
    FOREIGN KEY(food_id) REFERENCES food_item(food_id),

);




--user table
CREATE TABLE user(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(100) NOT NULL,
    user_phone VARCHAR(30) NOT NULL,
    user_password VARCHAR(255) not NULL,
    user_address TEXT NOT NULL,
    user_image_url TEXT NULL,
    user_role ENUM('CUSTOMER','ADMIN') DEFAULT 'CUSTOMER',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
);



--cart table
CREATE TABLE cart(
    cart_id VARCHAR(255) PRIMARY KEY ,
    user_id INT NOT NULL,
    food_id VARCHAR(255) NOT NULL,
    quantity INT NOT NULL CHECK(quantity>0),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(user_id) REFERENCES user (user_id)
);


--cart_item table
CREATE TABLE cart_items (
    cart_item_id  VARCHAR(255) PRIMARY KEY,
    user_id INT NOT NULL,
    food_id VARCHAR(255) NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (food_id) REFERENCES food_item(food_id) ON DELETE CASCADE
);


--payment table
CREATE TABLE payment(
    payment_id VARCHAR(255) PRIMARY KEY ,
    order_id VARCHAR(255) NOT NULL,
    payment_method ENUM('COD','CREDIT CARD','UPI') DEFAULT 'COD',
    transaction_id VARCHAR(100),
    payment_status ENUM('PENDING','SUCCESSFUL','FAILED') DEFAULT 'PENDING';
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(order_id) REFERENCES order(order_id)

);



--delivery table
CREATE TABLE delivery(
    delivery_id   VARCHAR(255) PRIMARY KEY ,
    order_id VARCHAR(255) NOT NULL,
    delivery_address TEXT NULL,
    delivery_status ENUM('PENDING', 'OUT_FOR_DELIVERY','DELIVERED') DEFAULT 'PENDING',
    delivered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(order_id) REFERENCES order(order_id)

);


--review_and_rating table
CREATE TABLE review_and_rating(
    review_id VARCHAR(255) PRIMARY KEY ,
    user_id INT NOT NULL,
    food_id VARCHAR(255) NOT NULL,
    rating INT NOT NULL,
    review_text TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(food_id) REFERENCES food_item(food_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)

);


--discount_and_coupon table
-- CREATE TABLE discount_and_coupon(
--     dicount_id VARCHAR(255) PRIMARY KEY ,
--     code VARCHAR(100),
--     discount_percentage DOUBLE NULL,
--     discount_valid_from DATE,
--     discount valid_to DATE,
--     discount_usage_limit INT NULL,
--     created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--     created_by VARCHAR(50),
--     updated_by VARCHAR(50)

-- );


--inventory table
-- CREATE TABLE inventory (
--     item_id VARCHAR(255) PRIMARY KEY ,
--     item_name VARCHAR(100) NOT NULL,
--     quantity DECIMAL  NOT NULL,
--     unit ENUM('KG', 'LTR', 'PCS') NOT NULL,
--     last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
-- );



