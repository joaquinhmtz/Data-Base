package com.codigo.controller;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.codigo.dao.Almacen;

import com.codigo.dao.Inventario;
import com.codigo.dao.Producto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;

public class Main {

    public static void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;

        List<Almacen> almacenes;
        List<Producto> productos;
        List<Inventario> inventarios;


        try{

            String resource ="com/codigo/recursos/conf.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            productos = sqlSession.selectList("com.codigo.dao.Producto.getTodosProductos");
            almacenes = sqlSession.selectList("com.codigo.dao.Almacen.getTodosAlmacenes");
            inventarios = sqlSession.selectList("com.codigo.dao.Inventario.getTodosInventarios");

            for(Almacen alm : almacenes){

                System.out.println(alm.toString());

            }

            System.out.println("\n\n\n");

            for(Producto pro : productos){

                System.out.println(pro.toString());

            }

            System.out.println("\n\n\n");


            for(Inventario inv : inventarios){

                System.out.println(inv.toString());

            }

        }catch (IOException ex){
            System.out.println("Error : "+ex.getMessage());
        }


    }
}
