/* Populate tabla clientes */
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893456', 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '1967-01-01', '2018-01-01');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('ce', '654389', 'Mr. Lenny', 'Doe', 'john.doe@gmail.com', '1968-01-01', '2018-01-02');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893457', 'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '1988-01-01', '2018-01-03');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893458', 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '1998-01-01', '2018-01-04');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893459', 'Erich', 'Gamma', 'erich.gamma@gmail.com', '2008-01-01', '2018-02-01');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893450', 'Richard', 'Helm', 'richard.helm@gmail.com', '1978-01-01', '2018-02-10');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('ce', '689098', 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '1958-01-01', '2018-02-18');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '2898987', 'John', 'Vlissides', 'john.vlissides@gmail.com', '1948-01-01', '2018-02-28');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893452', 'Dr. James', 'Gosling', 'james.gosling@gmail.com', '1955-01-01', '2018-03-03');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893453', 'Magma', 'Lee', 'magma.lee@gmail.com', '1989-01-01', '2018-03-04');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('ce', '567890', 'Tornado', 'Roe', 'tornado.roe@gmail.com', '1999-01-01', '2018-03-05');
INSERT INTO clientes (tipo, documento, nombre, apellido, email, fechanacimiento, create_at) VALUES('cc', '127893454', 'Jade', 'Doe', 'jane.doe@gmail.com', '1974-01-01', '2018-03-06');

/* Populate tabla premios */
INSERT INTO premio (descripcion, cantidad, create_at) VALUES('Balón Blanco', 5, CURDATE());
INSERT INTO premio (descripcion, cantidad, create_at) VALUES('Balón Negro', 2, CURDATE());
INSERT INTO premio (descripcion, cantidad, create_at) VALUES('Dulce Blanco', 5, CURDATE());
INSERT INTO premio (descripcion, cantidad, create_at) VALUES('Dulce Amarillo', 10, CURDATE());