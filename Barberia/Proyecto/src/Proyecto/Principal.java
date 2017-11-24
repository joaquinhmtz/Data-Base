package Proyecto;

import javax.sound.midi.MidiChannel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class Principal extends JFrame{
    private JPanel Principal;
    private JMenuBar menu;
    private JButton mostrarButton;
    public JDesktopPane desktop = new JDesktopPane();

    private JInternalFrame ver_tabla;
    private JInternalFrame insert_registro;




    public Principal(){


        this.setContentPane(Principal);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.Principal.add(this.desktop);
        this.menu = MenuNavegacion();

        this.setJMenuBar(menu);
        this.setDefaultCloseOperation(3);


    }



    public JMenuBar MenuNavegacion(){
        JMenuBar prueba = new JMenuBar();


        JMenu file = new JMenu("File");
        JMenuItem login = new JMenuItem("Login");
        JMenuItem salir = new JMenuItem("Salir");
        file.add(login);
        file.add(salir);
        prueba.add(file);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log = new Login();
                Main.pri.setVisible(false);
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JMenu admin = new JMenu("Admin");
        JMenuItem ver = new JMenuItem("Ver Registros");
        JMenuItem insert = new JMenuItem("Insertar Registro");
        admin.add(ver);
        admin.add(insert);
        prueba.add(admin);

        ver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ver_tabla = new Registros();
                ver_tabla.setVisible(true);
                desktop.add(ver_tabla);
            }
        });
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert_registro = new Formulario();
                insert_registro.setVisible(true);
                desktop.add(insert_registro);
            }
        });





        JMenu user = new JMenu("User");
        JMenuItem registrar = new JMenuItem("Nuevo Registro");

        user.add(registrar);

        prueba.add(user);

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert_registro = new Formulario();
                insert_registro.setVisible(true);
                desktop.add(insert_registro);
            }
        });



        return prueba;
    }

    public void Iniciar(int num){


        if(num == 1){


            Main.pri.setVisible(true);
            Main.pri.menu.getComponent(1).setEnabled(true);

        }

        if(num == 2){

            Main.pri.menu.getComponent(1).setEnabled(false);
            Main.pri.setVisible(true);
        }


    }



    
}
