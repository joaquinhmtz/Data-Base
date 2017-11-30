package Web.codigo.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;
import Web.codigo.dao.Almacen;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class AlmacenController extends SelectorComposer<Component> {

    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private static final long serialVersionUID = 1L;
    private Almacen almacen_vacio = new Almacen();
    private Almacen almacen_select = new Almacen();



    public Almacen getAlmacen_vacio() {
        return almacen_vacio;
    }

    public void setAlmacen_vacio(Almacen almacen_vacio) {
        this.almacen_vacio = almacen_vacio;
    }

    public Almacen getAlmacen_select() {
        return almacen_select;
    }

    public void setAlmacen_select(Almacen almacen_select) {
        this.almacen_select = almacen_select;
    }

    @Wire
    private Textbox busqueda_box;
    @Wire
    private Listbox almacenesListbox;
    @Wire
    private Component Datos;
    @Wire
    private Component Nuevo;
    @Wire
    private Component div_busqueda;
    @Wire
    private Textbox nombre;
    @Wire
    private Label ID;
    @Wire
    private Textbox calle;
    @Wire
    private Textbox numero;
    @Wire
    private Textbox colonia;
    @Wire
    private Textbox CP;
    @Wire
    private Textbox ciudad;
    @Wire
    private Textbox nombre_nuevo;
    @Wire
    private Label ID_nuevo;
    @Wire
    private Textbox calle_nuevo;
    @Wire
    private Textbox numero_nuevo;
    @Wire
    private Textbox colonia_nuevo;
    @Wire
    private Textbox CP_nuevo;
    @Wire
    private Textbox ciudad_nuevo;



    List<Almacen> almacenes;

    public void conexion() {

        try {


            String resource = "conf.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


    @NotifyChange("almacenes")
    @Listen("onClick = #searchButton")
    public void busqueda(){
        conexion();
        String busqueda = busqueda_box.getText();
        if(busqueda.equals("")){

            almacenes = sqlSession.selectList("Web.codigo.dao.Almacen.getTodosAlmacenes");
            almacenesListbox.setModel(new ListModelList<Almacen>(almacenes));

        }else{

            almacenes= sqlSession.selectList("Web.codigo.dao.Almacen.getByName",busqueda);
            almacenesListbox.setModel(new ListModelList<Almacen>(almacenes));

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

    @Listen("onClick = #nuevoButton,#menuInsert")
    public void nuevo(){
        Nuevo.setVisible(true);

        Datos.setVisible(false);
        conexion();

        int max =sqlSession.selectOne("Web.codigo.dao.Almacen.getMax");
        almacen_vacio.setId_almacen(max+1);
        ID_nuevo.setValue(Integer.toString(max+1));
        sqlSession.close();






    }

    @NotifyChange("almacen_select")
    @Listen("onSelect = #almacenesListbox")
    public void Detalles(){
        Datos.setVisible(true);
        Nuevo.setVisible(false);


        Set<Almacen> select = ((Selectable<Almacen>)almacenesListbox.getModel()).getSelection();
        if(select != null && !select.isEmpty()){

            Almacen almacen_select = select.iterator().next();
            ID.setValue(Integer.toString(almacen_select.getId_almacen()));
            nombre.setValue(almacen_select.getNombre_almacen());
            calle.setValue(almacen_select.getCalle());
            numero.setValue(Integer.toString(almacen_select.getNumero()));
            colonia.setValue(almacen_select.getColonia());
            CP.setValue(Integer.toString(almacen_select.getCP()));
            ciudad.setValue(almacen_select.getCiudad());


        }



    }


    @NotifyChange("almacen_select")
    @Listen("onClick=#update")
    public void Actualizar(){

        conexion();

        almacen_select.setId_almacen(Integer.parseInt(ID.getValue()));
        almacen_select.setNombre_almacen(nombre.getValue());
        almacen_select.setCalle(calle.getValue());
        almacen_select.setCiudad(ciudad.getValue());
        almacen_select.setCP(Integer.parseInt(CP.getValue()));
        almacen_select.setColonia(colonia.getValue());
        almacen_select.setNumero(Integer.parseInt(numero.getValue()));

        sqlSession.update("Web.codigo.dao.Almacen.UpdateAlmacen",almacen_select);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("Update Correcto");





    }

    @NotifyChange("almacen_select")
    @Listen("onClick=#delete")
    public void Borrar(){

        conexion();

        almacen_select.setId_almacen(Integer.parseInt(ID.getValue()));

        sqlSession.delete("Web.codigo.dao.Almacen.DeleteAlmacen",almacen_select.getId_almacen());
        sqlSession.commit();
        sqlSession.close();
        System.out.println("Delete Correcto");


    }


    @NotifyChange("almacen_vacio")
    @Listen("onClick=#insertar")
    public void Insertar(){

        conexion();
        almacen_vacio.setId_almacen(Integer.parseInt(ID_nuevo.getValue()));
        almacen_vacio.setNombre_almacen(nombre_nuevo.getValue());
        almacen_vacio.setCalle(calle_nuevo.getValue());
        almacen_vacio.setCiudad(ciudad_nuevo.getValue());
        almacen_vacio.setCP(Integer.parseInt(CP_nuevo.getValue()));
        almacen_vacio.setColonia(colonia_nuevo.getValue());
        almacen_vacio.setNumero(Integer.parseInt(numero_nuevo.getValue()));

        sqlSession.insert("Web.codigo.dao.Almacen.insertaAlmacen",almacen_vacio);
        sqlSession.commit();
        sqlSession.close();
    }




}
