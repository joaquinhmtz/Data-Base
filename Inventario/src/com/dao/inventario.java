package com.dao;

public class inventario {

    private int idinventario;
    private String fechaInventario;
    private producto CodigoBarras;
    private int IDalmacen;
    private float Precio;
    private int Cantidad;
    Lector lee = new Lector();

    public inventario() {}

    public inventario(int idinventario, String fechaInventario, producto codigoBarras, int IDalmacen, float precio, int cantidad) {
        this.idinventario = idinventario;
        this.fechaInventario = fechaInventario;
        this.CodigoBarras = codigoBarras;
        this.IDalmacen = IDalmacen;
        Precio = precio;
        Cantidad = cantidad;
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public String getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(String fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public producto getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(producto codigoBarras) {
        this.CodigoBarras = codigoBarras;
    }

    public int getIDalmacen() {
        return IDalmacen;
    }

    public void setIDalmacen(int IDalmacen) {
        this.IDalmacen = IDalmacen;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "inventario{" +
                "idinventario=" + idinventario +
                ", fechaInventario='" + fechaInventario + '\'' +
                ", CodigoBarras=" + CodigoBarras +
                ", IDalmacen=" + IDalmacen +
                ", Precio=" + Precio +
                ", Cantidad=" + Cantidad +
                ", lee=" + lee +
                '}';
    }

    public inventario llenarDatos(){
        inventario inven = new inventario();

        System.out.print("Id inventario: ");
        inven.setIdinventario(lee.leeNum());
        System.out.print("Fecha de inventario: ");
        inven.setFechaInventario(lee.leeDato());
        System.out.print("Código Barras: ");

        System.out.print("ID almacén: ");
        inven.setIDalmacen(lee.leeNum());
        System.out.print("Precio: ");
        inven.setPrecio(lee.leeFloat());
        System.out.print("Cantidad: ");
        inven.setCantidad(lee.leeNum());


        return inven;

    }


}
