create database barberia;
use barberia;

create table reporte(
	idreporte int,
    fecha date,
    descripcion varchar(50),
    primary key(idreporte)
);

create table factura(
	folio int,
    fechafactura date,
    lugarexpedicion varchar(50),
    primary key(folio)
);

create table catalogoReporte(
	idcatalogo int,
    idfactura int,
    idreporte int,
    primary key(idcatalogo),
    foreign key(idfactura) references factura(idfactura),
    foreign key(idreporte) references reporte(idreporte)
);

create table direccion(
	iddireccion int,
    calle varchar(50),
    numExt int,
    numInt int,
    codigopostal int,
    colonia varchar(50),
    delegacion varchar(50),
    primary key(iddireccion)
);

create table servicio(
	idservicio int,
    tipo varchar(50),
    precio float,
    primary key(idservicio)
);

create table cliente(
	idcliente int,
    nombre varchar(30),
    apellidop varchar(30),
    apellidom varchar(30),
    edad int,
    correo varchar(50),
    idservicio int,
    idcatalogo int,
    iddireccion int,
    primary key(idcliente),
    foreign key(idservicio) references servicio(idservicio),
    foreign key(idcatalogo) references catalogoReporte(idcatalogo),
    foreign key(iddireccion) references direccion(iddireccion)
);

create table cuenta(
	idcuenta int,
    pagobruto float,
    pagoneto float,
    descuento float,
    prestaciones float,
    vacaciones int,
    servicio_dia_mes varchar(40),
    primary key(idcuenta)
);

create table nomina(
	idnomina int,
    idcuenta int,
    primary key(idnomina),
    foreign key(idcuenta) references cuenta(idcuenta)
);

create table personal(
	idpersonal int,
    tipoempleado varchar(50),
    nombre_empleado varchar(30),
    apellidop_empleado varchar(30),
    apellidom_empleado varchar(30),
    copia_ife boolean,
    comprobante boolean,
    correo varchar(50),
    años_exp int,
    horario varchar(50),
    iddireccion int,
    idservicio int,
    idcuenta int,
    primary key(idpersonal),
    foreign key(iddireccion) references direccion(iddireccion),
    foreign key(idservicio) references servicio(idservicio),
    foreign key(idcuenta) references cuenta(idcuenta)
);

create table cita(
	idcita int,
    fecha_cita date,
    pagado boolean,
    idcliente int,
    idpersonal int,
    primary key(idcita),
    foreign key(idcliente) references cliente(idcliente),
    foreign key(idpersonal) references personal(idpersonal)
);

create table telefono(
	idtelefono int,
    tipo int,
    idcliente int,
    idpersonal int,
    primary key(idtelefono),
    foreign key(idcliente) references cliente(idcliente),
    foreign key(idpersonal) references personal(idpersonal)
);