package Proyecto;

public class Cliente {
    private int id;
    private String nombre;
    private int edad;
    private int id_telefono;
    private String email;
    private int id_servicio;
    private int id_producto;
    private boolean notificaciones;
    private int factura_datos;


    public Cliente(int id, String nombre, int edad, int id_telefono, String email, int id_servicio, int id_producto, boolean notificaciones, int factura_datos) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.id_telefono = id_telefono;
        this.email = email;
        this.id_servicio = id_servicio;
        this.id_producto = id_producto;
        this.notificaciones = notificaciones;
        this.factura_datos = factura_datos;
    }
    public Cliente(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public int getFactura_datos() {
        return factura_datos;
    }

    public void setFactura_datos(int factura_datos) {
        this.factura_datos = factura_datos;
    }
}
