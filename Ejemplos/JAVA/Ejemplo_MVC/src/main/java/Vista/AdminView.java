/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Pablo
 */
public class AdminView extends JFrame {

    public JButton btnRegistrarInstructor;
    public JButton btnRegistrarEstudiante;
    public JButton btnCerrarSesion;
    public JLabel lblTitulo;

    public AdminView() {
        setTitle("Panel de Administrador");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lblTitulo = new JLabel("Panel de Administrador");
        lblTitulo.setBounds(120, 20, 200, 30);
        add(lblTitulo);

        btnRegistrarInstructor = new JButton("Registrar Instructor");
        btnRegistrarInstructor.setBounds(100, 70, 180, 30);
        add(btnRegistrarInstructor);

        btnRegistrarEstudiante = new JButton("Registrar Estudiante");
        btnRegistrarEstudiante.setBounds(100, 120, 180, 30);
        add(btnRegistrarEstudiante);

        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setBounds(100, 170, 180, 30);
        add(btnCerrarSesion);
    }
}