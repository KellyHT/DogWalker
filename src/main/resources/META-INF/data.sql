
INSERT INTO raza(nombre) VALUES ('Akita');
INSERT INTO raza(nombre) VALUES ('Alaskan Malamute');
INSERT INTO raza(nombre) VALUES ('Bichón');
INSERT INTO raza(nombre) VALUES ('Bobtail ');
INSERT INTO raza(nombre) VALUES ('Boston Terrier');
INSERT INTO raza(nombre) VALUES ('Boxer');
INSERT INTO raza(nombre) VALUES ('Bull Terrier');
INSERT INTO raza(nombre) VALUES ('Bulldog');
INSERT INTO raza(nombre) VALUES ('Chihuahua');
INSERT INTO raza(nombre) VALUES ('Cocker');
INSERT INTO raza(nombre) VALUES ('Dálmata');
INSERT INTO raza(nombre) VALUES ('Dóberman');

INSERT INTO caracter(nombre) VALUES ('Sociable');
INSERT INTO caracter(nombre) VALUES ('Calmado');
INSERT INTO caracter(nombre) VALUES ('Agresivo');
INSERT INTO caracter(nombre) VALUES ('Tímido');
INSERT INTO caracter(nombre) VALUES ('Dominante');
INSERT INTO caracter(nombre) VALUES ('Docil');

INSERT INTO personalidad(nombre) VALUES ('Estricto');
INSERT INTO personalidad(nombre) VALUES ('Aventurero');
INSERT INTO personalidad(nombre) VALUES ('Divertido');
INSERT INTO personalidad(nombre) VALUES ('Sociable');
INSERT INTO personalidad(nombre) VALUES ('Conservador');

INSERT INTO distrito(nombre) VALUES ('Breña');
INSERT INTO distrito(nombre) VALUES ('Carabayllo');
INSERT INTO distrito(nombre) VALUES ('Chaclacayo');
INSERT INTO distrito(nombre) VALUES ('Chorrillos');
INSERT INTO distrito(nombre) VALUES ('Cieneguilla');
INSERT INTO distrito(nombre) VALUES ('Comas');
INSERT INTO distrito(nombre) VALUES ('El Agustino');
INSERT INTO distrito(nombre) VALUES ('Independencia');
INSERT INTO distrito(nombre) VALUES ('Jesús María');
INSERT INTO distrito(nombre) VALUES ('La Molina');
INSERT INTO distrito(nombre) VALUES ('La Victoria');
INSERT INTO distrito(nombre) VALUES ('Lima');
INSERT INTO distrito(nombre) VALUES ('Lince');
INSERT INTO distrito(nombre) VALUES ('Los Olivos');
INSERT INTO distrito(nombre) VALUES ('Lurigancho');
INSERT INTO distrito(nombre) VALUES ('Lurín');
INSERT INTO distrito(nombre) VALUES ('Magdalena del Mar');
INSERT INTO distrito(nombre) VALUES ('Miraflores');
INSERT INTO distrito(nombre) VALUES ('Pachacamac');
INSERT INTO distrito(nombre) VALUES ('Pucusana');
INSERT INTO distrito(nombre) VALUES ('Pueblo Libre');
INSERT INTO distrito(nombre) VALUES ('Puente Piedra');
INSERT INTO distrito(nombre) VALUES ('Punta Hermosa');
INSERT INTO distrito(nombre) VALUES ('Punta Negra');
INSERT INTO distrito(nombre) VALUES ('Rimac');
INSERT INTO distrito(nombre) VALUES ('San Bartolo');
INSERT INTO distrito(nombre) VALUES ('San Borja');
INSERT INTO distrito(nombre) VALUES ('San Isidro');
INSERT INTO distrito(nombre) VALUES ('San Juan de Lurigancho');
INSERT INTO distrito(nombre) VALUES ('San Juan de Miraflores');
INSERT INTO distrito(nombre) VALUES ('San Luis');
INSERT INTO distrito(nombre) VALUES ('San Martín de Porres');
INSERT INTO distrito(nombre) VALUES ('San Miguel');
INSERT INTO distrito(nombre) VALUES ('Santa Anita');
INSERT INTO distrito(nombre) VALUES ('Santa María del Mar');
INSERT INTO distrito(nombre) VALUES ('Santa Rosa');
INSERT INTO distrito(nombre) VALUES ('Santiago de Surco');
INSERT INTO distrito(nombre) VALUES ('Surquillo');
INSERT INTO distrito(nombre) VALUES ('Villa El Salvador');
INSERT INTO distrito(nombre) VALUES ('Villa María del Triunfo');

INSERT INTO dueno(apellido, contrasena, correo, direccion, fechadenacimiento, nombre, iddistrito)VALUES ('Parvina', '123', 'maria@gmail.com', 'Los claveles', '12/08/1990', 'Maria', 1);
INSERT INTO dueno(apellido, contrasena, correo, direccion, fechadenacimiento, nombre, iddistrito)VALUES ('Prado', '456', 'juan@gmail.com', 'el tambo', '01/08/1980', 'Juan', 5);
INSERT INTO dueno(apellido, contrasena, correo, direccion, fechadenacimiento, nombre, iddistrito)VALUES ('Chavez', '159', 'Pablo@gmail.com', 'N°123', '08/10/1987', 'Pablo', 1);
INSERT INTO dueno(apellido, contrasena, correo, direccion, fechadenacimiento, nombre, iddistrito)VALUES ('Rosales', '753', 'Miriam@gmail.com', 'las hormigas N° 147', '15/04/1989', 'Miriam', 11);

INSERT INTO can(descripcion, fechanacimiento, nombre, tamano, idcaracter, iddueno, idraza)	VALUES ('Es un perro muy sociable, le encanta jugar con la pelota', '10/08/2020', 'Pinky', 2, 1, 1, 1);
INSERT INTO can(descripcion, fechanacimiento, nombre, tamano, idcaracter, iddueno, idraza)	VALUES ('Es un perro muy tímido, camina muy lento', '10/03/2021', 'Loki', 2, 2, 2, 2);


INSERT INTO public.paseador(apellido, biografia, contrasena, correo, direccion, fechadenacimiento, montoservicio, nombre, iddistrito, idpersonalidad)VALUES ('Reyes', 'Soy estudiante de la carrera de Ingeniería de Sistemas de información de la UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','marcos@gmail.com', 'Calle 334 las palmas', '10/08/2000', '10.0', 'Marcos', 10, 1);
INSERT INTO public.paseador(apellido, biografia, contrasena, correo, direccion, fechadenacimiento, montoservicio, nombre, iddistrito, idpersonalidad)VALUES ('Prado', 'Soy estudiante de la carrera de Ingeniería Insdustrial -  UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','Sandra@gmail.com', 'Calle 334 las palmas', '10/08/1999', '10.0', 'Sandra', 11, 2);


