package Web.codigo.controller;

import Web.codigo.dao.Producto;
import Web.codigo.dao.Producto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Set;

public class ProductoController extends SelectorComposer<Component> {

    private MybatisController mybatis = new MybatisController();
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private static final long serialVersionUID = 1L;
    private Producto producto_vacio = new Producto();
    private Producto producto_select = new Producto();


    public Producto getProducto_vacio() {
        return producto_vacio;
    }

    public void setProducto_vacio(Producto producto_vacio) {
        this.producto_vacio = producto_vacio;
    }

    public Producto getProducto_select() {
        return producto_select;
    }

    public void setProducto_select(Producto producto_select) {
        this.producto_select = producto_select;
    }

    @Wire
    private Textbox busqueda_box;
    @Wire
    private Listbox productosListbox;
    @Wire
    private Component Datos;
    @Wire
    private Component Nuevo;
    @Wire
    private Component div_busqueda;
    @Wire
    private  Textbox  Descripcion;
    @Wire
    private Label Codigo_barra;
    @Wire
    private Textbox Descripcion_nuevo;
    @Wire
    private Label Codigo_barra_nuevo;




    List<Producto> productos;




    @NotifyChange("productos")
    @Listen("onClick = #searchButton")
    public void busqueda(){
        sqlSession=mybatis.conexion();
        String busqueda = busqueda_box.getText();
        if(busqueda.equals("")){

            productos = sqlSession.selectList("Web.codigo.dao.Producto.getTodosProductos");
            productosListbox.setModel(new ListModelList<Producto>(productos));

        }else{

            productos= sqlSession.selectList("Web.codigo.dao.Producto.getByName",busqueda);
            productosListbox.setModel(new ListModelList<Producto>(productos));

        }



    }

    @Listen("onClick=#menuVer")
    public void Ver(){

        div_busqueda.setVisible(true);

    }

    @Listen("onClick=#menuInsert")
    public void nuevo_menu(){
        nuevo();

    }

    @Listen("onClick = #nuevoButton")
    public void nuevo(){
        Nuevo.setVisible(true);

        Datos.setVisible(false);
        sqlSession=mybatis.conexion();

        int max =sqlSession.selectOne("Web.codigo.dao.Producto.getMax");
        producto_vacio.setCodigo_barra(max+1);
        Codigo_barra_nuevo.setValue(Integer.toString(max+1));
        sqlSession.close();






    }

    @NotifyChange("producto_select")
    @Listen("onSelect = #productosListbox")
    public void Detalles(){
        Datos.setVisible(true);
        Nuevo.setVisible(false);


        Set<Producto> select = ((Selectable<Producto>)productosListbox.getModel()).getSelection();
        if(select != null && !select.isEmpty()){

            Producto Producto_select = select.iterator().next();
            Codigo_barra.setValue(Integer.toString(Producto_select.getCodigo_barra()));
            Descripcion.setValue(Producto_select.getDescripcion_producto());

        }



    }


    @NotifyChange("Producto_select")
    @Listen("onClick=#update")
    public void Actualizar(){

        sqlSession=mybatis.conexion();

        producto_select.setCodigo_barra(Integer.parseInt(Codigo_barra.getValue()));
        producto_select.setDescripcion_producto(Descripcion.getValue());


        sqlSession.update("Web.codigo.dao.Producto.UpdateProducto",producto_select);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("Update Correcto");





    }

    @NotifyChange("Producto_select")
    @Listen("onClick=#delete")
    public void Borrar(){

        sqlSession=mybatis.conexion();

        producto_select.setCodigo_barra(Integer.parseInt(Codigo_barra.getValue()));

        sqlSession.delete("Web.codigo.dao.Producto.DeleteProducto",producto_select.getCodigo_barra());
        sqlSession.commit();
        sqlSession.close();
        System.out.println("Delete Correcto");


    }


    @NotifyChange("producto_vacio")
    @Listen("onClick=#insertar")
    public void Insertar(){

        sqlSession=mybatis.conexion();
        producto_vacio.setCodigo_barra(Integer.parseInt(Codigo_barra_nuevo.getValue()));
        producto_vacio.setDescripcion_producto(Descripcion_nuevo.getValue());


        sqlSession.insert("Web.codigo.dao.Producto.insertaProducto",producto_vacio);
        sqlSession.commit();
        sqlSession.close();
    }



}
