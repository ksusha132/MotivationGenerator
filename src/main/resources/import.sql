INSERT INTO user_info (id, age, name, sec_name) VALUES (1, 30, 'Maxim', 'Ignatenkov'),(2, 39, 'Pavel', 'Stepanov'), (3, 40, 'Alexander', 'Fomin'),(4, 26, 'Vasilii', 'Erastov'),(5, 26, 'Mark', 'Polyak');

INSERT INTO role (id, name) VALUES (1, 'ADMIN'), (2, 'USER'), (3, 'MODERATOR');

INSERT INTO user (id, login, password) VALUES (1, 'korfax', '123456'), (2, 'angryTomato', '123456'), (3, 'romantic', '123456'), (4, 'apple', '123456'), (5, 'loh', '123456');

INSERT INTO user_role (id, role_id, user_id) VALUES (1, 1, 1), (2, 3, 1), (3, 2, 2), (4, 3, 3), (5, 2, 4);