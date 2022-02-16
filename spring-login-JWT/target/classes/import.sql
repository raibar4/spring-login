INSERT INTO departamentos(nombre,ubicacion) VALUES("Ventas","Madrid");
INSERT INTO departamentos(nombre,ubicacion) VALUES("AtCliente","Sevila");
INSERT INTO departamentos(nombre,ubicacion) VALUES("Marketing","Valencia");
INSERT INTO departamentos(nombre,ubicacion) VALUES("Recursos","Barcelona");

INSERT INTO empleados(departamento_id,nombre,dni,telefono,salario) VALUES(1,"Jose","324f",5458,1000);
INSERT INTO empleados(departamento_id,nombre,dni,telefono,salario) VALUES(2,"Marcos","657j",8765,2000);

INSERT INTO jefes(departamento_id,nombre,dni,telefono,salario) VALUES(3,"Julia","345g",0214,3000);
INSERT INTO jefes(departamento_id,nombre,dni,telefono,salario) VALUES(4,"Marta","6734",7845,4000);

INSERT INTO usuarios(username,password,enabled) VALUES ("rolando","$2a$10$mDsLVZom5mTNqMbbj0NG9ebWH0NcN.u1pIq4n36S.2tFuPdQc7iqC",1);
INSERT INTO usuarios(username,password,enabled) VALUES ("admin","$2a$10$oY5b/Xk5QvqPXUmNnGkm3.avfeQ/f9/VSQFCPZ/v0phizE8iHh4gi",1);

INSERT INTO roles(nombre) VALUES ("ROLE_USER");
INSERT INTO roles(nombre) VALUES ("ROLE_ADMIN");

INSERT INTO usuarios_roles(usuario_id,role_id) VALUES (1,1);
INSERT INTO usuarios_roles(usuario_id,role_id) VALUES (2,2);
INSERT INTO usuarios_roles(usuario_id,role_id) VALUES (2,1);