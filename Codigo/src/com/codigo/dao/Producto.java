package com.codigo.dao;

public class Producto {

    private int codigo_barra;
    private String descripcion_producto;


    public Producto() {
    }

    public Producto(int codigo_barra, String descripcion_producto) {
        this.codigo_barra = codigo_barra;
        this.descripcion_producto = descripcion_producto;
    }

    public int getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(int codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo_barra=" + codigo_barra +
                ", descripcion_producto='" + descripcion_producto + '\'' +
                '}';
    }
}
