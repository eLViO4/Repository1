/*INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.role_name = 'ROLE_ADMIN'
WHERE u.username = 'admin'
  AND NOT EXISTS (SELECT 1
                  FROM user_roles ur
                  WHERE ur.user_id = u.id
                    AND ur.role_id = r.id);

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.role_name = 'ROLE_MANAGER'
WHERE u.username IN ('manager1', 'manager2', 'manager3')
  AND NOT EXISTS (SELECT 1
                  FROM user_roles ur
                  WHERE ur.user_id = u.id
                    AND ur.role_id = r.id);

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.role_name = 'ROLE_EDITOR'
WHERE u.username IN ('editor1', 'editor2', 'editor3', 'editor4', 'editor5')
  AND NOT EXISTS (SELECT 1
                  FROM user_roles ur
                  WHERE ur.user_id = u.id
                    AND ur.role_id = r.id);

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.role_name = 'ROLE_USER'
WHERE u.username IN ('user1', 'user2', 'user3', 'user4', 'user5', 'user6', 'user7', 'user8', 'user9', 'user10')
  AND NOT EXISTS (SELECT 1
                  FROM user_roles ur
                  WHERE ur.user_id = u.id
                    AND ur.role_id = r.id);



*/