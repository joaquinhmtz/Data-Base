package Proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog {

    private String adminL = "admin";
    private String passL = "admin";
    private String userU = "user";
    private String passU = "user";

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton Salir;
    private JButton Iniciar;
    private JPanel botones;
    private JPanel datos;
    private JTextField user_text;
    private JPasswordField pass_text;

    public Login() {

        this.setContentPane(contentPane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Acceder();
            }
        });
    }

    public void Acceder(){

        if(user_text.getText().equals(adminL) && pass_text.getText().equals(passL)){

            this.dispose();
            Main.pri.Iniciar(1);
        }
        if(user_text.getText().equals(userU) && pass_text.getText().equals(passU)){

            this.dispose();
            Main.pri.Iniciar(2);
        }

    }
}
