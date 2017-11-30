package com.dao;

public class almacen {

    private int IDAlmacen;
    private String nombreAlmacen;
    private String calle;
    private int numExt;
    private int codigoPostal;
    private String ciudad;
    Lector lee = new Lector();

    public almacen() {}

    public almacen(int IDAlmacen, String nombreAlmacen, String calle, int numExt, int codigoPostal, String ciudad) {
        this.IDAlmacen = IDAlmacen;
        this.nombreAlmacen = nombreAlmacen;
        this.calle = calle;
        this.numExt = numExt;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public int getIDAlmacen() {
        return IDAlmacen;
    }

    public void setIDAlmacen(int IDAlmacen) {
        this.IDAlmacen = IDAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumExt() {
        return numExt;
    }

    public void setNumExt(int numExt) {
        this.numExt = numExt;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "almacen{" +
                "IDAlmacen=" + IDAlmacen +
                ", nombreAlmacen='" + nombreAlmacen + '\'' +
                ", calle='" + calle + '\'' +
                ", numExt=" + numExt +
                ", codigoPostal=" + codigoPostal +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }

    public almacen llenarDatos(){
        almacen alma = new almacen();

        System.out.print("ID del almacén: ");
        alma.setIDAlmacen(lee.leeNum());
        System.out.print("Nombre: ");
        alma.setNombreAlmacen(lee.leeDato());
        System.out.print("Calle: ");
        alma.setCalle(lee.leeDato());
        System.out.print("Num Ext: ");
        alma.setNumExt(lee.leeNum());
        System.out.print("Código Postal: ");
        alma.setCodigoPostal(lee.leeNum());
        System.out.print("Ciudad: ");
        alma.setCiudad(lee.leeDato());

        return alma;

    }
}
