package Proyecto;

public class Cliente_Vista {
    private int id;
    private String nombre;
    private int telefono;
    private int num_tel;
    private int Edad;
    private String email;
    private String servicio;
    private int num_servicio;
    private int num_producto;
    private String producto;
    private boolean notificacion;
    private String rfc;
    private String razon_social;
    private String direccion;


    public Cliente_Vista(){}

    public Cliente_Vista(int id, String nombre, int telefono, String email, String servicio, String producto, boolean notificacion, String rfc, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.servicio = servicio;
        this.producto = producto;
        this.notificacion = notificacion;
        this.rfc = rfc;
        this.direccion = direccion;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getNum_servicio() {
        return num_servicio;
    }

    public void setNum_servicio(int num_servicio) {
        this.num_servicio = num_servicio;
    }

    public int getNum_producto() {
        return num_producto;
    }

    public void setNum_producto(int num_producto) {
        this.num_producto = num_producto;
    }

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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public boolean isNotificacion() {
        return notificacion;
    }

    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
