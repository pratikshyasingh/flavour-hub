CREATE SCHEMA flavour_hub;

USE flavour_hub;

--category table
CREATE TABLE category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    category_description TEXT NULL,
    category_image_url VARCHAR(250) NULL,
    food_status ENUM('Available','Unavailable') DEFAULT 'Available',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)   
);


--food-item table
CREATE TABLE food_item(
    food_id INT PRIMARY KEY,
    food_name VARCHAR(100),
    food_description TEXT NULL,
    price DOUBLE NOT NULL,
    food_status ENUM('Available','Unavailable') DEFAULT 'Available',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)
    FOREIGN KEY(category_id) REFERENCES category(category_id)

);


--food_category_mapping table
CREATE TABLE food_category_mapping(
    id INT PRIMARY KEY,
    food_id INT ,
    category_id INT,
    FOREIGN KEY(category_id) REFERENCES category(category_id),
    FOREIGN KEY(food_id) REFERENCES food_item(food_id)
);



--order table
CREATE TABLE order(
    order_id INT PRIMARY KEY,
    food_id INT --,
    order_quantity INT NOT NULL CHECK (quantity>0),
    total_price DOUBLE NOT NULL,
    order_status enum ('pending','confirmed','preparing','out_for_delivery','delivered','cancelled') DEFAULT 'pending',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(food_id) REFERENCES food_item(food_id)

);




--user table
CREATE TABLE user(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(100) NOT NULL,
    user_phone VARCHAR(30) NOT NULL,
    user_password VARCHAR(255) not NULL,
    user_role ENUM('CUSTOMER','ADMIN') DEFAULT 'CUSTOMER',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),

    
);



--cart table
CREATE TABLE cart(
    cart_id INT PRIMARY KEY,
    user_id INT --,
    food_id INT,
    quantity INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(user_id) REFERENCES user (user_id)



);


--payment table
CREATE TABLE payment(
    payment_id INT PRIMARY KEY,
    order_id INT,
    payment_method ENUM('cod','Credit card','UPI') DEFAULT --,
    transaction_id VARCHAR(100),
    payment_status ENUM('Pending','successful','failed') DEFAULT 'Pending';
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)

);



--delivery table
CREATE TABLE delivery(
    delivery-id INT PRIMARY KEY,
    order_id INT,
    delivery_address TEXT,
    delivery_status ENUM('Pending', 'Out for delivery','Delivered') DEFAULT 'Pending',
    delivered_at TIMESTAMP ,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(order_id) REFERENCES order(order_id)

);


--review_and_rating table
CREATE TABLE review_and_rating(
    review_id INT PRIMARY KEY,
    user_id INT --,
    food_id INT --,
    rating INT,
    review_text TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    FOREIGN KEY(food_id) REFERENCES food_item(food_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)



);


--discount_and_coupon table
CREATE TABLE discount_and_coupon(
    dicount_id INT PRIMARY KEY,
    code VARCHAR(100),
    discount_percentage DOUBLE,
    discount_valid_from DATE,
    discount valid_to DATE,
    discount_usage_limit INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)

    
);


--inventory table
CREATE TABLE inventory (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100) NOT NULL,
    quantity DECIMAL(10,2) NOT NULL,
    unit ENUM('kg', 'ltr', 'pcs') NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);



