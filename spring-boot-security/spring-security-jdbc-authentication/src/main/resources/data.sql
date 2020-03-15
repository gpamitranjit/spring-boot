INSERT INTO USERS(username, password, enabled) VALUES('user', '123', true);
INSERT INTO USERS(username, password, enabled) VALUES('admin', '123', true);
INSERT INTO USERS(username, password, enabled) VALUES('superadmin', '123', true);

INSERT INTO AUTHORITIES(username, authority) VALUES('user', 'ROLE_USER');
INSERT INTO AUTHORITIES(username, authority) VALUES('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES(username, authority) VALUES('superadmin', 'ROLE_SUPER_ADMIN');