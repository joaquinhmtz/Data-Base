package Web.codigo.dao;

public class Almacen {

    private int id_almacen;
    private String nombre_almacen;
    private String calle;
    private int numero;
    private String colonia;
    private int CP;
    private String ciudad;

    public Almacen() {
    }

    public Almacen(int id_almacen, String nombre_almacen, String calle, int numero, String colonia, int CP, String ciudad) {
        this.id_almacen = id_almacen;
        this.nombre_almacen = nombre_almacen;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.CP = CP;
        this.ciudad = ciudad;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "id_almacen=" + id_almacen +
                ", nombre_almacen='" + nombre_almacen + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", colonia='" + colonia + '\'' +
                ", CP=" + CP +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
