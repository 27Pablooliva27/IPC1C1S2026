/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Estudiante;
import Modelo.Instructor;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.RegistroEstudianteView;
import Vista.RegistroInstructorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Pablo
 */
public class RegistroController implements ActionListener {

    private RegistroInstructorView instructorView;
    private RegistroEstudianteView estudianteView;
    private UsuarioDAO usuarioDAO;

    public RegistroController(RegistroInstructorView instructorView, UsuarioDAO usuarioDAO) {
        this.instructorView = instructorView;
        this.usuarioDAO = usuarioDAO;

        this.instructorView.btnGuardar.addActionListener(this);
        this.instructorView.btnSalir.addActionListener(this);
    }

    public RegistroController(RegistroEstudianteView estudianteView, UsuarioDAO usuarioDAO) {
        this.estudianteView = estudianteView;
        this.usuarioDAO = usuarioDAO;

        this.estudianteView.btnGuardar.addActionListener(this);
        this.estudianteView.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (instructorView != null) {
            if (e.getSource() == instructorView.btnGuardar) {
                guardarInstructor();
            } else if (e.getSource() == instructorView.btnSalir) {
                instructorView.dispose();
            }
        }

        if (estudianteView != null) {
            if (e.getSource() == estudianteView.btnGuardar) {
                guardarEstudiante();
            } else if (e.getSource() == estudianteView.btnSalir) {
                estudianteView.dispose();
            }
        }
    }

    private void guardarInstructor() {
        String codigo = instructorView.txtCodigo.getText().trim();
        String nombre = instructorView.txtNombre.getText().trim();
        String password = instructorView.txtPassword.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(instructorView, "Todos los campos son obligatorios");
            return;
        }

        if (usuarioDAO.buscarPorCodigo(codigo) != null) {
            JOptionPane.showMessageDialog(instructorView, "El código ya existe");
            return;
        }

        Usuario instructor = new Instructor(codigo, nombre, password);
        usuarioDAO.agregar(instructor);

        JOptionPane.showMessageDialog(instructorView, "Instructor registrado correctamente");
        limpiarInstructor();
    }

    private void guardarEstudiante() {
        String codigo = estudianteView.txtCodigo.getText().trim();
        String nombre = estudianteView.txtNombre.getText().trim();
        String password = estudianteView.txtPassword.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(estudianteView, "Todos los campos son obligatorios");
            return;
        }

        if (usuarioDAO.buscarPorCodigo(codigo) != null) {
            JOptionPane.showMessageDialog(estudianteView, "El código ya existe");
            return;
        }

        Usuario estudiante = new Estudiante(codigo, nombre, password);
        usuarioDAO.agregar(estudiante);

        JOptionPane.showMessageDialog(estudianteView, "Estudiante registrado correctamente");
        limpiarEstudiante();
    }

    private void limpiarInstructor() {
        instructorView.txtCodigo.setText("");
        instructorView.txtNombre.setText("");
        instructorView.txtPassword.setText("");
    }

    private void limpiarEstudiante() {
        estudianteView.txtCodigo.setText("");
        estudianteView.txtNombre.setText("");
        estudianteView.txtPassword.setText("");
    }
}
