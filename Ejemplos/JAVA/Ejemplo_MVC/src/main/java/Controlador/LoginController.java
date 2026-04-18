/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.AdminView;
import Vista.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Pablo
 */
public class LoginController implements ActionListener {

    private LoginView view;
    private UsuarioDAO usuarioDAO;

    public LoginController(LoginView view) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();

        this.view.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnLogin) {
            iniciarSesion();
        }
    }

    private void iniciarSesion() {
        String codigo = view.txtCodigo.getText().trim();
        String password = new String(view.txtPassword.getPassword()).trim();

        if (codigo.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Debe ingresar código y contraseña");
            return;
        }

        Usuario usuario = usuarioDAO.buscar(codigo, password);

        if (usuario != null) {
            redirigirPorTipo(usuario);
        } else {
            JOptionPane.showMessageDialog(view, "Credenciales incorrectas");
        }
    }

    private void redirigirPorTipo(Usuario usuario) {
        if (usuario.getTipo().equals("ADMIN")) {
            JOptionPane.showMessageDialog(view, "Bienvenido Administrador");

            AdminView adminView = new AdminView();
            new AdminController(adminView, usuarioDAO);
            adminView.setVisible(true);

            view.dispose();

        } else if (usuario.getTipo().equals("INSTRUCTOR")) {
            JOptionPane.showMessageDialog(view, "Ingreso como Instructor");
        } else if (usuario.getTipo().equals("ESTUDIANTE")) {
            JOptionPane.showMessageDialog(view, "Ingreso como Estudiante");
        } else {
            JOptionPane.showMessageDialog(view, "Tipo de usuario no válido");
        }
    }
}