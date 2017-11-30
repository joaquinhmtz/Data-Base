package com.controller;
import com.dao.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args){

        Lector lee = new Lector();

        SqlSessionFactory sqlMapper = null;
        SqlSession session = null;

        List<producto> productos;
        List<inventario> inventarios;
        List<almacen> almacenes;

        try{
            String resource = "com/recursos/configuracion.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            session = sqlMapper.openSession();
            productos = session.selectList("com.dao.producto.selectProducto");
            inventarios = session.selectList("com.dao.inventario.selectInventario");
            almacenes = session.selectList("com.dao.almacen.selectAlmacen");

            /*producto produ = new producto();
            produ = produ.llenarDatos();
            session.insert("com.dao.producto.insertProducto",produ);
            session.commit();
            session.close();*/

            /*almacen alma = new almacen();
            alma = alma.llenarDatos();
            session.insert("com.dao.almacen.insertAlmacen",alma);
            session.commit();
            session.close();*/

            /*inventario inven = new inventario();
            inven = inven.llenarDatos();
            session.insert("com.dao.inventario.insertInventario", inven);
            session.commit();
            session.close();*/

            /*producto produ = new producto();
            System.out.print("Código de barras a eliminar: ");
            int aux = lee.leeNum();
            session.delete("com.dao.producto.deleteProducto", aux);
            session.commit();
            session.close();*/

            /*almacen alma = new almacen();
            System.out.print("Almacen a borrar: ");
            int aux2 = lee.leeNum();
            session.delete("com.dao.almacen.deleteAlmacen", aux2);
            session.commit();
            session.close();*/

            inventario inven = new inventario();
            System.out.print("Inventario a borrar: ");
            int aux3 = lee.leeNum();
            session.delete("com.dao.inventario.deleteInventario", aux3);
            session.commit();
            session.close();

           // session.insert("com.dao.producto.insertProducto",aux);
           // session.commit();
            //session.close();
            for(producto pro : productos) {
                System.out.println(pro.toString());
            }

            for (almacen alm: almacenes) {
                System.out.println(alm.toString());
            }

            for (inventario inv: inventarios) {
                System.out.println(inv.toString());
            }




        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void insertProducto(){
        String sql = "insert into producto values (?,?)";
        producto produ = new producto();
        produ = produ.llenarDatos();
        SqlSession session = null;
        session.insert("com.dao.producto.insertProducto",produ);
        session.commit();
        session.close();

    }

}
