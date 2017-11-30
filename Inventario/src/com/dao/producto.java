package com.dao;

public class producto {

    private int codigoBarras;
    private String descripcion;
    Lector lee = new Lector();

    public producto() {}

    public producto(int codigoBarras, String descripcion) {
        this.codigoBarras = codigoBarras;
        this.descripcion = descripcion;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "producto{" +
                "codigoBarras=" + codigoBarras +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public producto llenarDatos(){
        producto prod = new producto();

        System.out.print("Código de barras: ");
        prod.setCodigoBarras(lee.leeNum());
        System.out.print("Descripción: ");
        prod.setDescripcion(lee.leeDato());

        return prod;

    }

    public producto deleteProd(){
        producto prod = new producto();

        System.out.print("Códigode barras a eliminar: ");
        prod.setCodigoBarras(lee.leeNum());
        prod.getCodigoBarras();

        return prod;
    }
}
