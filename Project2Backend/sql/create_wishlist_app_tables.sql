
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(20) NOT NULL UNIQUE,
                       password VARCHAR(16) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       role ENUM('admin', 'user') DEFAULT 'user',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE wishlist (
                          item_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          item_name VARCHAR(100) NOT NULL,
                          item_description TEXT,
                          added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
