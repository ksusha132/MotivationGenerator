INSERT INTO user (id, age, name, sec_name) VALUES (1, 30, 'Maxim', 'Ignatenkov');
INSERT INTO user (id, age, name, sec_name) VALUES (2, 39, 'Pavel', 'Stepanov');
INSERT INTO user (id, age, name, sec_name) VALUES (3, 40, 'Alexander', 'Fomin');
INSERT INTO user (id, age, name, sec_name) VALUES (4, 26, 'Vasilii', 'Erastov');
INSERT INTO user (id, age, name, sec_name) VALUES (5, 26, 'Mark', 'Polyak');

INSERT INTO login (id, login, password) VALUES (1, 'maxFluffy', '123456');
INSERT INTO login (id, login, password) VALUES (2, 'angryTomato', '123456');

INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');
INSERT INTO role (id, name) VALUES (3, 'MODERATOR');

INSERT INTO user_role (id, role_id, user_id) VALUES (1, 1, 1);
INSERT INTO user_role (id, role_id, user_id) VALUES (2, 3, 1);
INSERT INTO user_role (id, role_id, user_id) VALUES (3, 2, 2);
INSERT INTO user_role (id, role_id, user_id) VALUES (4, 3, 3);
INSERT INTO user_role (id, role_id, user_id) VALUES (5, 2, 4)