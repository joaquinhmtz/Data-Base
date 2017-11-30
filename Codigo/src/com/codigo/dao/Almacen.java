package com.codigo.dao;

public class Almacen {

    private int id_almacen;
    private String nombre_almacen;
    private String direccion;

    public Almacen() {
    }

    public Almacen(int id_almacen, String nombre_almacen, String direccion) {
        this.id_almacen = id_almacen;
        this.nombre_almacen = nombre_almacen;
        this.direccion = direccion;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getNombre_almacen() {
        return nombre_almacen;
    }

    public void setNombre_almacen(String nombre_almacen) {
        this.nombre_almacen = nombre_almacen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "id_almacen=" + id_almacen +
                ", nombre_almacen='" + nombre_almacen + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
