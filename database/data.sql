--value insertion to category table

INSERT INTO category (Category_name, Category_description, Category_image_url, created_by, updated_by) 
VALUES 
('Beverages', 'Drinks and beverages', 'https://example.com/images/beverages.jpg', 'admin', 'admin'),
('Desserts', 'Sweet treats and desserts', 'https://example.com/images/desserts.jpg', 'admin', 'admin'),
('Main Course', 'Main course dishes', 'https://example.com/images/main_course.jpg', 'admin', 'admin');


--value insertion to food item table

INSERT INTO food_item (food_id, food_name, food_description, price, created_by, updated_by) 
VALUES 
(1, 'Cappuccino', 'A hot coffee drink with steamed milk foam', 150.00, 'admin', 'admin'),
(2, 'Chocolate Cake', 'Rich and creamy chocolate layered cake', 350.00, 'admin', 'admin'),
(3, 'Grilled Chicken', 'Grilled chicken with herbs and spices', 250.00, 'admin', 'admin');


-- Insert values into food_category_mapping table
INSERT INTO food_category_mapping (id, food_id, category_id) VALUES (1, 1, 1), (2, 2, 1), (3, 3, 2);

-- Insert values into order table
INSERT INTO `order` (order_id, food_id, order_quantity, total_price, order_status, created_date, updated_date, created_by, updated_by) 
VALUES 
(1, 1, 2, 250.0, 'pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'), 
(2, 2, 1, 150.0, 'confirmed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(3, 3, 3, 450.0, 'preparing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');

-- Insert values into user table
INSERT INTO user (user_id, user_name, user_email, user_phone, user_password, user_role, created_date, updated_date, created_by, updated_by)
VALUES 
(1, 'John Doe', 'john.doe@example.com', '1234567890', 'password123', 'customer', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(2, 'Jane Smith', 'jane.smith@example.com', '0987654321', 'password456', 'customer', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(3, 'Admin User', 'admin@example.com', '1122334455', 'adminpass', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');

-- Insert values into cart table
INSERT INTO cart (cart_id, user_id, food_id, quantity, created_date, updated_date, created_by, updated_by) 
VALUES 
(1, 1, 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(2, 2, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(3, 3, 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');

-- Insert values into payment table
INSERT INTO payment (payment_id, order_id, payment_method, transaction_id, payment_status, created_date, updated_date, created_by, updated_by)
VALUES 
(1, 1, 'cod', 'TXN123456', 'Pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(2, 2, 'Credit card', 'TXN654321', 'successful', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(3, 3, 'UPI', 'TXN789012', 'failed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');

-- Insert values into delivery table
INSERT INTO delivery (delivery-id, order_id, delivery_address, delivery_status, delivered_at, created_date, updated_date, created_by, updated_by)
VALUES 
(1, 1, '123 Main St, City, Country', 'Pending', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(2, 2, '456 Oak St, City, Country', 'Out for delivery', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(3, 3, '789 Pine St, City, Country', 'Delivered', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');

-- Insert values into review_and_rating table
INSERT INTO review_and_rating (review_id, user_id, food_id, rating, review_text, created_date, updated_date, created_by, updated_by)
VALUES 
(1, 1, 1, 5, 'Great food!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(2, 2, 2, 4, 'Good taste', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(3, 3, 3, 3, 'Average', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');

-- Insert values into discount_and_coupon table
INSERT INTO discount_and_coupon (dicount_id, code, discount_percentage, discount_valid_from, discount_valid_to, discount_usage_limit, created_date, updated_date, created_by, updated_by)
VALUES 
(1, 'WELCOME10', 10.0, '2025-02-05', '2025-03-05', 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(2, 'SPRING20', 20.0, '2025-03-01', '2025-04-01', 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
(3, 'SUMMER15', 15.0, '2025-05-01', '2025-06-01', 75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');

-- Insert values into inventory table
INSERT INTO inventory (item_name, quantity, unit, last_updated) 
VALUES 
('Tomatoes', 50.00, 'kg', CURRENT_TIMESTAMP),
('Potatoes', 30.00, 'kg', CURRENT_TIMESTAMP),
('Milk', 20.00, 'ltr', CURRENT_TIMESTAMP);
