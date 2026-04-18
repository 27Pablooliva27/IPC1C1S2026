
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

/**
 *
 * @author Pablo
 */
import javax.swing.*;

public class LoginView extends JFrame {
    public JTextField txtCodigo;
    public JPasswordField txtPassword;
    public JButton btnLogin;

    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 80, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(100, 20, 150, 25);
        add(txtCodigo);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(20, 60, 80, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 60, 150, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 100, 100, 30);
        add(btnLogin);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
