package Proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Registros extends JInternalFrame {

    private JPanel principal = new JPanel(new BorderLayout());
    private JLabel titulo = new JLabel("Ver Registros",SwingConstants.CENTER);
    private JButton ver = new JButton("Ver");
    private JTable tabla;
    private Conexion conex = new Conexion();
    private JButton eleminar = new JButton("Eliminar");;
    private JButton modificar = new JButton("Modificar");;

    public Registros(){

        InicializarComponentes();
        this.setContentPane(principal);
        this.setBounds(400,200,500,100);
        this.setVisible(true);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);

        ver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Select();
            }
        });

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    public void InicializarComponentes(){

        principal.add(titulo,BorderLayout.NORTH);
        principal.add(ver,BorderLayout.SOUTH);
        this.add(principal);

    }

    public void Select(){

        this.tabla= CrearTabla();
        JScrollPane sc = new JScrollPane(this.tabla);
        setEventoMouseClicked();
        principal.add(sc,BorderLayout.CENTER);
        this.setBounds(100,100,1000,500);

    }

    public JTable CrearTabla() {

        PreparedStatement ps;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        Conexion cone = new Conexion();
        Connection conn = null;
        int col = 0;
        Object[] nomCol = {""};
        int row = 0;
        Object[][] data = {{}};
        int i;


        try {

            String sql2 = "Select MAX(id_cliente) from Cliente";
            conn = cone.Connect();
            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()) {

                row = rs.getInt(1);

            }


        } catch (SQLException ex) {

            System.out.println("Error : " + ex.getMessage());

        }

        try {


            String sql = "Select * from Vista_Cliente";
            conn = cone.Connect();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            col = rsm.getColumnCount();
            nomCol = new String[col+2];




            for (i = 0; i < col; i++) {

                nomCol[i] = rsm.getColumnName(i + 1);

            }

            nomCol[10]="Modificar";
            nomCol[11]="Eliminar";



            data = new Object[row][col+2];


            i=0;
            while (rs.next()) {
                int j = 0;
                data[i][j] = rs.getInt(1);
                data[i][j + 1] = rs.getString(2);
                data[i][j + 2] = rs.getInt(3);
                data[i][j + 3] = rs.getInt(4);
                data[i][j + 4] = rs.getString(5);
                data[i][j + 5] = rs.getString(6);
                data[i][j + 6] = rs.getString(7);
                data[i][j + 7] = rs.getInt(8);
                data[i][j + 8] = rs.getString(9);
                data[i][j + 9] = rs.getString(10);
                data[i][j + 10] = modificar;
                data[i][j + 11] = eleminar;



                i++;
            }



        }catch(SQLException ex ){

            System.out.println("Error : "+ex.getMessage());


        }








        DefaultTableModel modelo = new DefaultTableModel(data,nomCol){


            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabla2 = new JTable();
        tabla2.setModel(modelo);
        tabla2.setDefaultRenderer(Object.class, new Render());
        tabla2.setRowHeight(20);





        return tabla2;





    }

    public void tablaMouseClicked(MouseEvent evt){



        int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY()/tabla.getRowHeight();

        if(fila < tabla.getRowCount() && fila >=0 && column < tabla.getColumnCount() && column>=0 ){
            Object value =  tabla.getValueAt(fila,column);
            if(value instanceof  JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(column==10){
                    Update reg = new Update();

                    reg.Actualizar(fila);
                    this.dispose();

                }
                if(column==11){

                    conex.Delete(fila+1);
                    this.dispose();
                }
            }
        }
    }

    private void setEventoMouseClicked()
    {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                tablaMouseClicked(e);
            }
        });
    }


}
