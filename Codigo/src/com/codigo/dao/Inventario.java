package com.codigo.dao;

import java.util.Date;

public class Inventario {

    private Producto producto;
    private Almacen  almacen;
    private float precio;
    private int cant;
    private String fecha;

    public Inventario() {
    }


    public Inventario(Producto producto, Almacen almacen, float precio, int cant, String fecha) {
        this.producto = producto;
        this.almacen = almacen;
        this.precio = precio;
        this.cant = cant;
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "producto = " + producto.getCodigo_barra() +
                ", almacen = " + almacen.getId_almacen() +
                ", precio = " + precio +
                ", cant = " + cant +
                ", fecha = '" + fecha + '\'' +
                '}';
    }
}
