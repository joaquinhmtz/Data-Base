package Web.codigo.controller;

import Web.codigo.dao.Inventario;
import Web.codigo.dao.Producto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class InventarioController extends SelectorComposer<Component> {
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
    private Listbox inventariosListbox;
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




    List<Producto> inventarios;




    @NotifyChange("inventarios")
    @Listen("onClick = #searchButton")
    public void busqueda(){
        sqlSession=mybatis.conexion();
        String busqueda = busqueda_box.getText();
        if(busqueda.equals("")){

            inventarios = sqlSession.selectList("Web.codigo.dao.Inventario.getTodosInventarios");
            inventariosListbox.setModel(new ListModelList<Producto>(inventarios));

        }else{

            inventarios= sqlSession.selectList("Web.codigo.dao.Producto.getByName",busqueda);
            inventariosListbox.setModel(new ListModelList<Producto>(inventarios));

        }



    }

    @Listen("onClick=#menuVer")
    public void Ver(){



    }




    @NotifyChange("producto_select")
    @Listen("onSelect = #productosListbox")
    public void Detalles(){



        Set<Inventario> select = ((Selectable<Inventario>)inventariosListbox.getModel()).getSelection();
        if(select != null && !select.isEmpty()){

            Inventario inventario_select = select.iterator().next();
            Codigo_barra.setValue(inventario_select.getFecha().toString());


        }



    }




}
