package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Formulario extends JInternalFrame {
    private JPanel principal = new JPanel();
    private JPanel PanelEnviar = new JPanel();
    private JPanel Titulop = new JPanel();
    private JLabel titulo = new JLabel("Datos Usuario",SwingConstants.CENTER);
    private JPanel campos = new JPanel();
    private JTextField nombreTextField = new JTextField(15);
    private JTextField telefonoTextField = new JTextField(15);
    private JTextField emailTextField = new JTextField(15);
    private JTextField edadTextField = new JTextField(15);
    private JComboBox servicioComboBox;
    private JComboBox productoComboBox;
    private JTextField RFCTextField = new JTextField(15);
    private JTextField direccionTextField = new JTextField(15);
    private JRadioButton siRadioButton = new JRadioButton("Si");
    private JRadioButton noRadioButton = new JRadioButton("No");
    private ButtonGroup grupo = new ButtonGroup();
    private JLabel nombre = new JLabel("Nombre");
    private JLabel Telefono = new JLabel("Telefono");
    private JLabel email = new JLabel("Email");
    private JLabel servicio = new JLabel("Servicio");
    private JLabel producto =  new JLabel("Producto");
    private JLabel rfc = new JLabel("RFC");
    private JLabel direccion = new JLabel("Direccion");
    private JLabel notificacion = new JLabel("Notificacion");
    private JLabel edad = new JLabel("Edad");

    private JButton Enviar = new JButton("Enviar");

    int conservar = 0;


    public Formulario(){

        Inicializar();
        this.setContentPane(principal);
        this.setLocation(500,100);
        this.pack();
        //this.setVisible(true);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);


        Enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!nombreTextField.getText().equals("") && !telefonoTextField.getText().equals("") && !email.getText().equals("") && !RFCTextField.getText().equals("") && !direccionTextField.getText().equals("")) {
                    LLenar_Insertar();
                }else{
                    JDialog aviso = new JDialog();
                    JPanel conten = new JPanel();
                    JLabel avisoText = new JLabel("Falta un campo por llenar");
                    avisoText.setHorizontalAlignment(0);
                    conten.add(avisoText);
                    aviso.add(conten);
                    aviso.setContentPane(conten);
                    aviso.pack();
                    aviso.setVisible(true);
                    aviso.setLocationRelativeTo(null);


                }



            }
        });



    }

    public void Inicializar(){

        principal.setLayout(new BorderLayout());

        Titulop.add(titulo);
        principal.add(Titulop, BorderLayout.NORTH);

        campos.setLayout(new GridLayout(10,2));

        String servicios_texto[] ={"Corte","Lavado","Rasurar","Corte Caballero","Completo"};
        DefaultComboBoxModel model = new DefaultComboBoxModel(servicios_texto);
        String productos_texto[] ={"Shampoo","Acondiccionar","Crema para Afeitar","Locion","Tijeras"};
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(productos_texto);

        servicioComboBox = new JComboBox(model);
        productoComboBox = new JComboBox(model2);


        JPanel nombres = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
        nombres.add(nombre);
        nombres.add(nombreTextField);
        campos.add(nombres);

        JPanel telefonos = new JPanel(new FlowLayout());
        telefonos.add(Telefono);
        telefonos.add(telefonoTextField);
        campos.add(telefonos);

        JPanel emails = new JPanel(new FlowLayout());
        emails.add(email);
        emails.add(emailTextField);
        campos.add(emails);

        JPanel edades = new JPanel(new FlowLayout());
        edades.add(edad);
        edades.add(edadTextField);
        campos.add(edades);

        JPanel servicios = new JPanel(new FlowLayout());
        servicios.add(servicio);
        servicios.add(servicioComboBox);
        campos.add(servicios);

        JPanel productos = new JPanel(new FlowLayout());
        productos.add(producto);
        productos.add(productoComboBox);
        campos.add(productos);

        JPanel rfcs = new JPanel(new FlowLayout());
        rfcs.add(rfc);
        rfcs.add(RFCTextField);
        campos.add(rfcs);

        JPanel direcciones = new JPanel(new FlowLayout());

        direcciones.add(direccion);
        direcciones.add(direccionTextField);

        campos.add(direcciones);

        JPanel notificaciones = new JPanel(new FlowLayout());

        notificaciones.add(notificacion);

        grupo.add(siRadioButton);
        grupo.add(noRadioButton);
        JPanel botones = new JPanel(new FlowLayout());
        botones.add(siRadioButton);
        botones.add(noRadioButton);
        notificaciones.add(botones);
        campos.add(notificaciones);



        principal.add(campos,BorderLayout.CENTER);

        PanelEnviar.setLayout(new GridLayout(1,2));
        PanelEnviar.add(Enviar);
        principal.add(PanelEnviar,BorderLayout.SOUTH);


    }

    public void LLenar_Insertar(){

        Cliente_Vista cliente = new Cliente_Vista();
        Conexion con = new Conexion();

        cliente.setNombre(nombreTextField.getText());
        cliente.setTelefono(Integer.parseInt(telefonoTextField.getText()));
        cliente.setEmail(emailTextField.getText());
        cliente.setNum_servicio(servicioComboBox.getSelectedIndex()+1);
        cliente.setNum_producto(productoComboBox.getSelectedIndex()+1);
        cliente.setRfc(RFCTextField.getText());
        cliente.setDireccion(direccionTextField.getText());
        cliente.setEdad(Integer.parseInt(edadTextField.getText()));
        if(siRadioButton.isSelected()){
            cliente.setNotificacion(true);
        }
        if(noRadioButton.isSelected()){
            cliente.setNotificacion(false);
        }

        this.dispose();
        String result = con.Insertar(cliente);


    }





}
