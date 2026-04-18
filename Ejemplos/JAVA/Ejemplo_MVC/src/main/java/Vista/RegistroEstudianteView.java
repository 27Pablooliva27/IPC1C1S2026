/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Pablo
 */
public class RegistroEstudianteView extends JFrame {

    public JTextField txtCodigo;
    public JTextField txtNombre;
    public JTextField txtPassword;
    public JButton btnGuardar;
    public JButton btnSalir;

    public RegistroEstudianteView() {
        setTitle("Registrar Estudiante");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 30, 180, 25);
        add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 70, 180, 25);
        add(txtNombre);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(30, 110, 100, 25);
        add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(140, 110, 180, 25);
        add(txtPassword);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(70, 180, 100, 30);
        add(btnGuardar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(200, 180, 100, 30);
        add(btnSalir);
    }
}
