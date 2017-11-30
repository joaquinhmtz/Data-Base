package Web.codigo.controller;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import Web.codigo.dao.Almacen;

import Web.codigo.dao.Inventario;
import Web.codigo.dao.Producto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class Main {

    private List<Almacen> almacenes;
    private List<Producto> productos;
    private List<Inventario> inventarios;
    private String nombre;
    private Almacen almacen = new Almacen();
    private int i=3;
    private Almacen almacen2 = new Almacen();
    private Almacen prueba[] = new Almacen[5];
    private String id="8";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Almacen[] getPrueba() {
        return prueba;
    }

    public void setPrueba(Almacen[] prueba) {
        this.prueba = prueba;
    }

    public Almacen getAlmacen2() {
        return almacen2;
    }

    public void setAlmacen2(Almacen almacen2) {
        this.almacen2 = almacen2;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(List<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    @Init
    public  void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;


        try{


            String resource = "conf.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            this.productos = sqlSession.selectList("Web.codigo.dao.Producto.getTodosProductos");
            this.almacenes = sqlSession.selectList("Web.codigo.dao.Almacen.getTodosAlmacenes");
            this.inventarios = sqlSession.selectList("Web.codigo.dao.Inventario.getTodosInventarios");

            this.prueba[0] = this.almacenes.get(0);
            this.prueba[1] = this.almacenes.get(1);


        }catch (IOException ex){
            System.out.println("Error : "+ex.getMessage());

        }




    }

    @NotifyChange("i")
    @Command
    public void aumentar(){
        if(this.i<4) {
            this.i++;
        }
        else{
            this.i=0;
        }
    }

    @NotifyChange("almacen")
    @Command
    public void MostrarAlmacenes(){

        almacen = almacenes.get(this.i);

    }

    @NotifyChange("almacen2")
    @Command
    public void ListarAlmacenes(){



        almacen2 = almacenes.get(this.i);




    }

    @NotifyChange("id")
    @Command
    public void MostrarDatos(){

        System.out.println("El Id es : "+this.id);
    }






}
