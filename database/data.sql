-- category
INSERT INTO category (category_id, category_name, category_description, category_image_url, created_by, updated_by)
VALUES (UUID(), 'Beverages', 'Drinks and beverages', 'https://example.com/images/beverages.jpg', 'admin', 'admin');

INSERT INTO category (category_id, category_name, category_description, category_image_url, created_by, updated_by)
VALUES (UUID(), 'Desserts', 'Sweet treats and desserts', 'https://example.com/images/desserts.jpg', 'admin', 'admin');

INSERT INTO category (category_id, category_name, category_description, category_image_url, created_by, updated_by)
VALUES (UUID(), 'Main Course', 'Main course dishes', 'https://example.com/images/main_course.jpg', 'admin', 'admin');

INSERT INTO category (category_id, category_name, category_description, category_image_url, created_by, updated_by)
VALUES (UUID(), 'Appetizers', 'Starters and appetizers', 'https://example.com/images/appetizers.jpg', 'admin', 'admin');

INSERT INTO category (category_id, category_name, category_description, category_image_url, created_by, updated_by)
VALUES (UUID(), 'Salads', 'Fresh and healthy salads', 'https://example.com/images/salads.jpg', 'admin', 'admin');


INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Beverages' LIMIT 1), 'Iced Coffee', 'Refreshing iced coffee with a hint of vanilla.', 4.99, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Desserts' LIMIT 1), 'Tiramisu', 'Classic Italian coffee-flavored dessert with mascarpone cheese.', 6.99, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Main Course' LIMIT 1), 'Grilled Chicken Steak', 'Juicy grilled chicken served with herb butter and mashed potatoes.', 14.99, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Appetizers' LIMIT 1), 'Mozzarella Sticks', 'Crispy golden mozzarella sticks served with marinara sauce.', 7.49, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Salads' LIMIT 1), 'Caesar Salad', 'Crisp romaine lettuce with Caesar dressing, croutons, and Parmesan.', 8.99, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Beverages' LIMIT 1), 'Iced Latte', 'Creamy iced latte with a shot of espresso.', 5.49, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Beverages' LIMIT 1), 'Green Tea', 'Refreshing hot green tea with lemon.', 3.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Beverages' LIMIT 1), 'Mango Smoothie', 'Fresh mango blended with yogurt and honey.', 6.49, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Beverages' LIMIT 1), 'Cold Brew Coffee', 'Slow-steeped coffee served chilled.', 4.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Beverages' LIMIT 1), 'Lemonade', 'Classic homemade lemonade with mint.', 3.49, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Desserts' LIMIT 1), 'Chocolate Lava Cake', 'Warm chocolate cake with a molten center.', 7.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Desserts' LIMIT 1), 'Cheesecake', 'Classic creamy cheesecake with a graham cracker crust.', 6.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Desserts' LIMIT 1), 'Apple Pie', 'Traditional apple pie with cinnamon and a flaky crust.', 5.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Desserts' LIMIT 1), 'Brownie Sundae', 'Fudgy brownie topped with vanilla ice cream and chocolate sauce.', 8.49, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Desserts' LIMIT 1), 'Panna Cotta', 'Italian-style vanilla pudding with berry coulis.', 6.49, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Main Course' LIMIT 1), 'Salmon Teriyaki', 'Grilled salmon glazed with teriyaki sauce.', 16.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Main Course' LIMIT 1), 'Beef Stroganoff', 'Tender beef with creamy mushroom sauce, served over pasta.', 15.49, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Main Course' LIMIT 1), 'Vegetarian Pasta', 'Pasta with fresh vegetables and a light olive oil sauce.', 12.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Main Course' LIMIT 1), 'BBQ Ribs', 'Slow-cooked ribs with a tangy barbecue sauce.', 18.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Main Course' LIMIT 1), 'Butter Chicken', 'Rich and creamy tomato-based curry with tender chicken.', 14.99, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Appetizers' LIMIT 1), 'Garlic Bread', 'Crispy garlic bread with a hint of herbs.', 4.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Appetizers' LIMIT 1), 'Bruschetta', 'Grilled bread topped with tomatoes, basil, and balsamic glaze.', 6.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Appetizers' LIMIT 1), 'Buffalo Wings', 'Spicy buffalo wings served with blue cheese dip.', 9.49, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Appetizers' LIMIT 1), 'Stuffed Mushrooms', 'Mushrooms stuffed with cheese and herbs, baked to perfection.', 7.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Appetizers' LIMIT 1), 'Spinach Artichoke Dip', 'Creamy spinach and artichoke dip with tortilla chips.', 8.49, 'AVAILABLE', 'admin', 'admin');

INSERT INTO food_item (food_id, category_id, food_name, food_description, price, food_item_status, created_by, updated_by) 
VALUES 
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Salads' LIMIT 1), 'Greek Salad', 'Fresh tomatoes, cucumbers, olives, and feta cheese.', 9.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Salads' LIMIT 1), 'Caprese Salad', 'Tomatoes, mozzarella, and basil drizzled with balsamic glaze.', 10.49, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Salads' LIMIT 1), 'Quinoa Salad', 'Quinoa with mixed greens, avocado, and citrus dressing.', 11.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Salads' LIMIT 1), 'Waldorf Salad', 'Apples, walnuts, celery, and grapes in a light dressing.', 10.99, 'AVAILABLE', 'admin', 'admin'),
(UUID(), (SELECT category_id FROM category WHERE category_name = 'Salads' LIMIT 1), 'Asian Chicken Salad', 'Grilled chicken with crunchy veggies and sesame dressing.', 12.49, 'AVAILABLE', 'admin', 'admin');



