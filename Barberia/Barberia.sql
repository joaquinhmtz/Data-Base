
create database barberia;

use barberia;


create table direccion(
	id_direccion int,
    calle varchar(50),
    numExt int,
    codigo_postal int,
    colonia varchar(50),
    ciudad varchar(50),
    primary key(id_direccion)
);

insert direccion values (1,"pruebaCalle",13,11820,"America","CDMX");
insert direccion values (2,"pruebaCalle2",15,11822,"America","CDMX");


create table facturacion(
	id_facturacion int,
    RFC varchar(25),
    razon_social varchar(50),
    id_direccion int,
    primary key(id_facturacion),
    foreign key(id_direccion) references direccion(id_direccion)
);

insert facturacion values (1,"AUOL","Fernando",1);

create table tipo_empleado(
	id_tipo int,
    tipo varchar(50),
    primary key(id_tipo)
);

insert tipo_empleado values(1,"Barbero");

create table servicio(
	id_servicio int,
    nombre_servicio varchar(50),
    precio float,
    primary key(id_servicio)
);

insert servicio values (1,"Corte",500);
insert servicio values (2,"Peinado",1000);


create table horario(
	id_horario int,
    tipo_horario varchar(40),
    primary key(id_horario)
);

insert horario values(1,"Matutino");

create table cliente(
	id_cliente int,
    nombre_cliente varchar(30),
    apellidop varchar(30),
    apellidom varchar(30),
    edad int,
    correo varchar(50),
    notificacion boolean,
    id_facturacion int,
    id_direccion int,
    primary key(id_cliente),
    foreign key(id_facturacion) references facturacion(id_facturacion),
    foreign key(id_direccion) references direccion(id_direccion)
);

insert into cliente values (1, "juan", "gonzalez", "lopez", 22, "juan@hotmail.com", true, 1, 1);

create table cliente_servicio(
	id_cliente int,
    id_servicio int,
    primary key(id_cliente, id_servicio),
    foreign key(id_cliente) references cliente(id_cliente),
    foreign key(id_servicio) references servicio(id_servicio)
);

insert into cliente_servicio values(1,1);
insert into cliente_servicio values(1,2);

create table personal(
	id_personal int,
    id_tipo int,
    nombre_empleado varchar(30),
    apellidop_empleado varchar(30),
    apellidom_empleado varchar(30),
    copia_ife boolean,
    comprobante boolean,
    correo varchar(50),
    años_exp float,
    id_horario int,
    id_direccion int,
    
    primary key(id_personal),
    foreign key(id_direccion) references direccion(id_direccion),
    foreign key(id_tipo) references tipo_empleado(id_tipo),
    foreign key(id_horario) references horario(id_horario)
);

insert personal values(1,1,"Pancho","Barraza","Tepito",true,false,"pancho@hotmail.com",1.5,1,2);

create table personal_servicios(
	id_personal int,
    id_servicio int,
    primary key(id_personal, id_servicio),
    foreign key(id_personal) references personal(id_personal),
    foreign key(id_servicio) references servicio(id_servicio)
);

insert personal_servicios values (1,1);
insert personal_servicios values (1,2);

create table cita(
	id_cita int,
    fecha_cita date,
    pagado boolean,
    id_cliente int,
    id_personal int,
    primary key(id_cita),
    foreign key(id_cliente) references cliente(id_cliente),
    foreign key(id_personal) references personal(id_personal)
);


insert into cita values (1,'2017-11-21',false,1,1);



create table descuento(
	id_descuento int,
    concepto varchar(40),
    cantidad_descuento float,
    primary key(id_descuento)
);

insert into descuento values(1, "IVA", 0.16);
insert into descuento values(2, "ISR", 0.33);

create table prestaciones(
	id_prestaciones int,
    concepto_prestaciones varchar(40),
    aumento float,
    primary key(id_prestaciones)
);

insert into prestaciones values(1, "BONO", 0.30);
insert into prestaciones values(2, "Prima Vacacional", 0.50);

create table nomina(
	id_nomina int,
    pago_bruto float,
    pago_neto float,
    dias_vacaciones int,
    num_servicios int,
    id_personal int,
    primary key(id_nomina),
    foreign key(id_personal) references personal (id_personal)
);






DELIMITER  $$
create procedure CalculoNeto(in id int,in _pagobruto float, in vacaciones int,in numero_servicios int, in iva float,in id_personal int )
BEGIN


Declare pago_neto float default 0;


set pago_neto = _pagobruto*iva;

insert nomina values(id,_pagobruto,pago_neto,vacaciones,numero_servicios, id_personal);





END $$
DELIMITER ; 



Call CalculoNeto(1,10000,5,10,0.16,1);
Call CalculoNeto(2,20000,10,20,0.15,1);


create table nomina_descuento(
	id_nomina int,
    id_descuento int,
    primary key(id_nomina,id_descuento),
    foreign key (id_nomina) references nomina(id_nomina),
    foreign key (id_descuento) references descuento(id_descuento)
);

insert nomina_descuento values (1,1);
insert nomina_descuento values (1,2);


create table nomina_prestaciones(
	id_nomina int,
    id_prestaciones int,
    primary key(id_nomina,id_prestaciones),
    foreign key(id_nomina) references nomina(id_nomina),
    foreign key(id_prestaciones) references prestaciones(id_prestaciones)
);

insert nomina_prestaciones values(1,1);
insert nomina_prestaciones values(1,2);

create table telefono(
	id_telefono int,
    telefono int,
    id_cliente int null,
    id_personal int null,
    primary key(id_telefono),
    foreign key(id_cliente) references cliente(id_cliente),
    foreign key(id_personal) references personal(id_personal)
);

insert into telefono values (1,5567576,1,null);
insert into telefono values (2,5577686,null,1);




/* Vistas */

create view personal_vista as
select  per.id_personal, tip.tipo, concat(per.nombre_empleado,' ',per.apellidop_empleado, ' ',per.apellidom_empleado) as nombre_empleado,tel.telefono,concat(dir.calle,' ',dir.numExt,', ',dir.colonia,' , ',dir.ciudad,' , ',dir.codigo_postal) as direccion_empleado,per.copia_ife,per.comprobante,per.correo,per.años_exp,hor.tipo_horario,concat(ser.nombre_servicio) as nombre_servicio from(((((
personal as per inner join direccion as dir on per.id_direccion = dir.id_direccion)
inner join tipo_empleado as tip on per.id_tipo = tip.id_tipo)
inner join horario as hor on per.id_horario = hor.id_horario)
inner join telefono as tel on per.id_personal = tel.id_personal),
personal_servicios as pers inner join servicio as ser on pers.id_servicio = ser.id_servicio);  

create view cliente_vista as
select cli.id_cliente, concat(cli.nombre_cliente,' ',cli.apellidop,' ',cli.apellidom) as nombre_cliente,tel.telefono, cli.edad, ser.nombre_servicio , cli.notificacion, fac.RFC, fac.razon_social, dir.calle, dir.colonia from((((
cliente as cli inner join direccion as dir on cli.id_direccion = dir.id_direccion)
inner join facturacion as fac on fac.id_facturacion = cli.id_facturacion)
inner join telefono as tel on cli.id_cliente = tel.id_cliente),
cliente_servicio as clis inner join servicio as ser on clis.id_servicio = ser.id_servicio); 


create view Nomina_vista as
select Concat(per.nombre_empleado, ' ',per.apellidop_empleado,' ',per.apellidom_empleado) as nombre_empleado, nom.id_nomina,tipe.tipo,nom.pago_bruto,des.concepto,des.cantidad_descuento,pres.concepto_prestaciones,pres.aumento,nom.dias_vacaciones,nom.num_servicios,nom.pago_neto from((((((
nomina as nom inner join nomina_descuento as nomd on nom.id_nomina = nomd.id_nomina)
inner join descuento as des on nomd.id_descuento = des.id_descuento)
inner join nomina_prestaciones as nomp on nom.id_nomina = nomp.id_nomina)
inner join prestaciones as pres on nomp.id_prestaciones = pres.id_prestaciones)
inner join personal as per on nom.id_personal = per.id_personal)
inner join tipo_empleado as tipe on per.id_tipo = tipe.id_tipo);

create view cita_vista as
select cit.id_cita, cit.fecha_cita, Concat(cli.nombre_cliente,' ',cli.apellidop,' ',cli.apellidom) as nombre_cliente,tel.telefono as telefono_cliente, concat(per.nombre_empleado,' ',per.apellidop_empleado,' ',per.apellidom_empleado) as nombre_empleado,cit.pagado from(((
cita as cit inner join cliente as cli on cit.id_cliente = cli.id_cliente)
inner join personal as per on cit.id_personal = per.id_personal)
inner join telefono as tel on cli.id_cliente = tel.id_cliente);

create view Servicios as
select serv.nombre_servicio, serv.precio from servicio as serv;

