package Proyecto;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.*;



public class Conexion {

    Connection conn = null;
    PreparedStatement pr = null;
    ResultSet rs = null;




    private static String driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String password = "luis2330";
    private static String base = "proyecto";
    private static String servidor = "jdbc:mysql://localhost:3306/";
    private static String completa = servidor+base;
    int id_max=0;

    public Connection Connect(){

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(completa, user, password);

        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conn = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conn = null;
        }catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        conn = null;
        }
        return conn;

    }

    public ArrayList<Cliente_Vista> listar(){

        Conexion conex = new Conexion();

        conn = conex.Connect();

        ArrayList<Cliente_Vista> clientes = new ArrayList<>();
        String sql = "select * from vista_cliente";

        try {

            pr = conn.prepareStatement(sql);
            rs = pr.executeQuery();

            while (rs.next()) {
                Cliente_Vista cliente = new Cliente_Vista();
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getInt(3));
                cliente.setEmail(rs.getString(4));
                cliente.setServicio(rs.getString(5));
                cliente.setProducto(rs.getString(6));
                cliente.setNotificacion(rs.getBoolean(7));
                cliente.setRfc(rs.getString(8));
                cliente.setRazon_social(rs.getString(9));
                cliente.setDireccion(rs.getString(10));


                clientes.add(cliente);

                conn.close();
            }


        }catch(SQLException ex){

                System.out.println("Error:" + ex.getMessage());

        }


        return clientes;


    }


    public String Insertar(Cliente_Vista CV){

        Cliente cliente  = new Cliente();
        Conexion con = new Conexion();



        conn = con.Connect();
        String result = null;

        if(id_max==0){
            try {


                String sql = "SELECT MAX(id_cliente) FROM cliente";
                pr = conn.prepareStatement(sql);
                rs = pr.executeQuery();
                while(rs.next()){

                    id_max=rs.getInt(1)+1;

                }



            }catch (Exception e){
                System.out.println("Error"+ e.getMessage());
                result = e.getMessage();

            }

        }


        try{


            String sql  = "Call Registrador(?,?,?,?,?,?,?,?,?,?)";
            pr = conn.prepareStatement(sql);
            pr.setInt(1,id_max);
            pr.setString(2,CV.getNombre());
            pr.setInt(3,CV.getEdad());
            pr.setString(4,CV.getEmail());
            pr.setInt(5,CV.getNum_servicio());
            pr.setInt(6,CV.getNum_producto());
            pr.setBoolean(7, CV.isNotificacion());
            pr.setString(8,CV.getRfc());
            pr.setString(9, CV.getDireccion());
            pr.setInt(10,CV.getTelefono());
            int aux = pr.executeUpdate();
            if(aux==1){

                JOptionPane.showMessageDialog(null,"Se Inserto de manera correcta");
            }else{
                JOptionPane.showMessageDialog(null,"No pude insertar al cliente");
            }

            conn.close();




        }catch (SQLException e){
            System.out.println("Error"+ e.getMessage());
            result = e.getMessage();
        }


        return result;

    }

    public void Update(Cliente_Vista CV ){

        Conexion cone = new Conexion();

        conn = cone.Connect();

        String sql = "Call Actualizador (?,?,?,?,?,?,?,?,?,?)";

        try {

            pr = conn.prepareStatement(sql);
            pr.setInt(1,CV.getId());
            pr.setString(2,CV.getNombre());
            pr.setInt(3,CV.getEdad());
            pr.setString(4,CV.getEmail());
            pr.setInt(5,CV.getNum_servicio());
            pr.setInt(6,CV.getNum_producto());
            pr.setBoolean(7,CV.isNotificacion());
            pr.setString(8,CV.getRfc());
            pr.setString(9,CV.getDireccion());
            pr.setInt(10,CV.getTelefono());
            int aux = pr.executeUpdate();

            if(aux==1){

                JOptionPane.showMessageDialog(null,"Se Actualizo de manera correcta");
            }else{
                JOptionPane.showMessageDialog(null,"No pude Actualizar al cliente");
            }






        }catch (SQLException ex){

            System.out.println("Error "+ex.getMessage());
        }





    }


    public void Delete(int reg){

        int aux;
        Conexion cone = new Conexion();

       try{
           conn= cone.Connect();

           String sql = "DELETE FROM cliente WHERE id_cliente = ?";
           pr = conn.prepareStatement(sql);
           pr.setInt(1,reg);
           aux = pr.executeUpdate();

           if(aux==1){

               JOptionPane.showMessageDialog(null,"Se Borro de manera correcta");
           }else{
               JOptionPane.showMessageDialog(null,"No se puede Borrar al cliente");
           }

           conn.close();



       }catch (SQLException ex){

       }

    }





}
