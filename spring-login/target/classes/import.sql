INSERT INTO usuarios(usu,pass) VALUES("jm","hola");
INSERT INTO usuarios(usu,pass) VALUES("la","adios");

INSERT INTO departamentos(nombre,ubicacion) VALUES("Ventas","Madrid");
INSERT INTO departamentos(nombre,ubicacion) VALUES("AtCliente","Sevila");
INSERT INTO departamentos(nombre,ubicacion) VALUES("Marketing","Valencia");
INSERT INTO departamentos(nombre,ubicacion) VALUES("Recursos","Barcelona");

INSERT INTO empleados(departamento_id,nombre,dni,telefono,salario) VALUES(1,"Jose","324f",5458,1000);
INSERT INTO empleados(departamento_id,nombre,dni,telefono,salario) VALUES(2,"Marcos","657j",8765,2000);

INSERT INTO jefes(departamento_id,nombre,dni,telefono,salario) VALUES(3,"Julia","345g",0214,3000);
INSERT INTO jefes(departamento_id,nombre,dni,telefono,salario) VALUES(4,"Marta","6734",7845,4000);