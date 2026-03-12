-- Seed sample products for Mini E-commerce API
-- Total products: 12

INSERT INTO products (name, description, price, image, stock) VALUES
('Laptop Dell XPS 13', 'High performance ultrabook with Intel processor', 1500, 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8', 10),
('MacBook Pro M3', 'Powerful laptop for developers and designers', 2200, 'https://images.unsplash.com/photo-1518779578993-ec3579fee39f', 8),
('iPhone 15 Pro', 'Latest Apple smartphone with advanced camera', 1200, 'https://images.unsplash.com/photo-1592750475338-74b7b21085ab', 15),
('Samsung Galaxy S24', 'Flagship Android smartphone with AMOLED display', 1100, 'https://images.unsplash.com/photo-1610945265064-0e34e5519bbf', 20),
('iPad Pro', 'Powerful tablet with Apple M2 chip', 999, 'https://images.unsplash.com/photo-1585790050230-5dd28404ccb9', 12),
('Logitech MX Master 3', 'Ergonomic wireless mouse for productivity', 120, 'https://images.unsplash.com/photo-1587829741301-dc798b83add3', 30),
('Keychron K6 Keyboard', 'Mechanical keyboard with RGB lighting', 150, 'https://images.unsplash.com/photo-1618384887929-16ec33fab9ef', 25),
('Sony WH-1000XM5', 'Industry leading noise cancelling headphones', 400, 'https://images.unsplash.com/photo-1580894894513-541e068a3e2b', 18),
('Samsung 27 4K Monitor', 'Ultra HD monitor for work and gaming', 450, 'https://images.unsplash.com/photo-1527443224154-c4a3942d3acf', 14),
('Apple Watch Series 9', 'Smartwatch with advanced health tracking', 500, 'https://images.unsplash.com/photo-1516574187841-cb9cc2ca948b', 22),
('GoPro Hero 12', 'Action camera for adventure and sports', 550, 'https://images.unsplash.com/photo-1508898578281-774ac4893a78', 10),
('Canon EOS R50', 'Mirrorless camera for creators and vloggers', 900, 'https://images.unsplash.com/photo-1516035069371-29a1b244cc32', 6);

INSERT INTO carts (user_id) VALUES (1);