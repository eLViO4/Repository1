/*INSERT INTO users (username, password)
SELECT 'admin', 'admin'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'admin');

INSERT INTO users(username, password)
SELECT 'manager1', 'manager'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'manager1');
INSERT INTO users(username, password)
SELECT 'manager2', 'manager'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'manager2');
INSERT INTO users(username, password)
SELECT 'manager3', 'manager'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'manager3');

INSERT INTO users(username, password)
SELECT 'editor1', 'editor'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'editor1');
INSERT INTO users(username, password)
SELECT 'editor2', 'editor'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'editor2');
INSERT INTO users(username, password)
SELECT 'editor3', 'editor'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'editor3');
INSERT INTO users(username, password)
SELECT 'editor4', 'editor'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'editor4');
INSERT INTO users(username, password)
SELECT 'editor5', 'editor'
WHERE NOT EXISTS(SELECT 1 FROM users WHERE username = 'editor5');

INSERT INTO users (username, password)
SELECT 'user1', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user1');
INSERT INTO users (username, password)
SELECT 'user2', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user2');
INSERT INTO users (username, password)
SELECT 'user3', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user3');
INSERT INTO users (username, password)
SELECT 'user4', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user4');
INSERT INTO users (username, password)
SELECT 'user5', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user5');
INSERT INTO users (username, password)
SELECT 'user6', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user6');
INSERT INTO users (username, password)
SELECT 'user7', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user7');
INSERT INTO users (username, password)
SELECT 'user8', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user8');
INSERT INTO users (username, password)
SELECT 'user9', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user9');
INSERT INTO users (username, password)
SELECT 'user10', 'user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user10');
*/