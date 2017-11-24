use proyecto;

create view vista_cliente as
SELECT cli.id,cli.nombre,cli.edad,tel.telefono,cli.email,ser.servicio,pro.nombre_producto,cli.notificacion,dat.rfc,dat.direccion
FROM ((((cliente as cli
inner join telefono as tel on cli.telefonos_id=tel.id_telefono)
inner join producto as pro on cli.productos_id=pro.id_producto)
inner join servicio as  ser on cli.servicios_id=ser.id_servicio)
inner join datos_factura as dat on cli.factura_datos =dat.rfc);



		