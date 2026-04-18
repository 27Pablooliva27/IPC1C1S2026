/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.UsuarioDAO;
import Vista.AdminView;
import Vista.LoginView;
import Vista.RegistroEstudianteView;
import Vista.RegistroInstructorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Pablo
 */
public class AdminController implements ActionListener {

    private AdminView adminView;
    private UsuarioDAO usuarioDAO;

    public AdminController(AdminView adminView, UsuarioDAO usuarioDAO) {
        this.adminView = adminView;
        this.usuarioDAO = usuarioDAO;

        this.adminView.btnRegistrarInstructor.addActionListener(this);
        this.adminView.btnRegistrarEstudiante.addActionListener(this);
        this.adminView.btnCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == adminView.btnRegistrarInstructor) {
            RegistroInstructorView vistaInstructor = new RegistroInstructorView();
            new RegistroController(vistaInstructor, usuarioDAO);
            vistaInstructor.setVisible(true);
        }

        if (e.getSource() == adminView.btnRegistrarEstudiante) {
            RegistroEstudianteView vistaEstudiante = new RegistroEstudianteView();
            new RegistroController(vistaEstudiante, usuarioDAO);
            vistaEstudiante.setVisible(true);
        }

        if (e.getSource() == adminView.btnCerrarSesion) {
            adminView.dispose();

            LoginView loginView = new LoginView();
            new LoginController(loginView);
            loginView.setVisible(true);
        }
    }
}
