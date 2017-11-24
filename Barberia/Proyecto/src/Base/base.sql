/*Drop DATABASE proyecto;*/
create database proyecto;

use proyecto;





create table servicio(
id_servicio integer,
servicio varchar(40),
precio int(5),
primary key(id_servicio)
);

create table producto(
id_producto integer,
nombre_producto varchar(25),
descripcion varchar(40),
precio int(4),
primary key(id_producto)
);

create table cliente(
id_cliente integer,
nombre varchar(50),
edad integer,
email varchar(35),
servicios_id integer,
productos_id integer,
notificacion boolean,
primary key(id_cliente),
foreign key(servicios_id) references servicio(id_servicio),
foreign key(productos_id) references producto(id_producto)
);


create table datos_factura(
id_factura int,
rfc varchar(13),
razon_social varchar(30),
direccion varchar(60),
id_cliente integer,
primary key(id_factura),
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE  ON UPDATE CASCADE
);



create table telefono(
id_telefono integer AUTO_INCREMENT,
telefono int(10),
id_cliente int,
primary key(id_telefono),
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE ON UPDATE CASCADE
);

/* producto */

insert into producto values(1,"Shampoo","Shampoo para el cabello",200);
insert into producto values(2,"Acondicionador","Acondicionar de para cabello",300);
insert into producto values(3,"Crema de afeitar","Crema de afeitar para barba",150);
insert into producto values(4,"Locion","Para despues de Afeitarse",200);
insert into producto values(5,"Tijeras","Tijeras para cortar",300);





/* servicio */

insert into servicio values (1,"corte",100);
insert into servicio values (2,"lavado",150);
insert into servicio values (3,"rasurar",120);
insert into servicio values (4,"corte cabellero",60);
insert into servicio values (5,"completo",300);

/* Cliente */

insert into cliente values(1,"Luis",21,"read2330@gmail.com",1,1,true);
insert into cliente values(2,"Fernando",21,"jesus@gmail.com",2,2,true);
insert into cliente values(3,"Jose",21,"jose@gmail.com",3,3,true);
insert into cliente values(4,"Jesus",21,"tuilo@gmail.com",4,4,true);
insert into cliente values(5,"Tulio",21,"turte@gmail.com",5,5,true);

/* Datos factura */

insert into datos_factura values (1,"AUOL","Luis","Poniente 73",1);
insert into datos_factura values (2,"LOYU","Fernando","Poniente 75",2);
insert into datos_factura values (3,"OPYT","Jose","Poniente 74",3);
insert into datos_factura values (4,"KCR","Jesus","Poniente 76",4);
insert into datos_factura values (5,"OPIT","Tulio","Poniente 79",5);





/* telefonos */

insert into telefono values(NULL ,55707564,1);
insert into telefono values(NULL ,55707530,2);
insert into telefono values(NULL ,55704505,3);
insert into telefono values(NULL ,55708908,4);
insert into telefono values(NULL ,55708909,5);





create view vista_cliente as
SELECT cli.id_cliente,cli.nombre,cli.edad,tel.telefono,cli.email,ser.servicio,pro.nombre_producto,cli.notificacion,dat.rfc,dat.direccion
FROM ((((cliente as cli
inner join telefono as tel on cli.id_cliente=tel.id_cliente)
inner join producto as pro on cli.productos_id=pro.id_producto)
inner join servicio as  ser on cli.servicios_id=ser.id_servicio)
inner join datos_factura as dat on cli.id_cliente = dat.id_cliente);

select * from vista_cliente;


/* Store */
DELIMITER $$

CREATE PROCEDURE Registrador(in id_cliente_aux int, in nombre_aux VARCHAR(30),in edad_aux INT,in email_aux VARCHAR(30),in servicio_aux int , in producto_aux int,in notificacion_aux BOOLEAN,in rfc_aux VARCHAR(13),in direccion_aux VARCHAR(60),in telefono_aux INT)
  BEGIN

      INSERT INTO cliente VALUES (id_cliente_aux,nombre_aux,edad_aux,email_aux,servicio_aux,producto_aux,notificacion_aux);
      INSERT INTO datos_factura VALUES (id_cliente_aux,rfc_aux,nombre_aux,direccion_aux,id_cliente_aux);
      INSERT INTO telefono VALUES (NULL,telefono_aux,id_cliente_aux);

  END $$
DELIMITER ;
/*CALL Registrador(6,"Prueba",21,"Prueba@hotmail.com",3,2,true,"PRUEBA","Prueba1234",566454);*/
DELIMITER $$

CREATE PROCEDURE Actualizador(in id_cliente_aux int, in nombre_aux VARCHAR(30),in edad_aux INT,in email_aux VARCHAR(30),in servicio_aux int , in producto_aux int,in notificacion_aux BOOLEAN,in rfc_aux VARCHAR(13),in direccion_aux VARCHAR(60),in telefono_aux INT)
  BEGIN

    UPDATE cliente set nombre = nombre_aux, edad = edad_aux, email = email_aux, servicios_id = servicio_aux, productos_id = producto_aux, notificacion = notificacion_aux WHERE id_cliente = id_cliente_aux;
    UPDATE telefono set telefono = telefono_aux WHERE id_telefono = id_cliente_aux;
    UPDATE datos_factura set rfc = rfc_aux, razon_social = nombre_aux, direccion = direccion_aux WHERE id_factura = id_cliente_aux;


  END $$
DELIMITER ;




SELECT  * FROM  cliente;















