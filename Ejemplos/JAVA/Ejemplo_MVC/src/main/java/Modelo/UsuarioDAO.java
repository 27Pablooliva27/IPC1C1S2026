/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;

/**
 *
 * @author Pablo
 */
public class UsuarioDAO {

    private Usuario[] usuarios = new Usuario[100];
    private int contador = 0;
    private final String ARCHIVO = "usuarios.ser";

    public UsuarioDAO() {
        cargarDesdeArchivo();
    }

    // Cargar datos
    private void cargarDesdeArchivo() {
        try {
            File file = new File(ARCHIVO);

            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                usuarios = (Usuario[]) in.readObject();
                contador = contarUsuarios();
                in.close();
            } else {
                // Crear admin inicial SOLO si no existe archivo
                crearAdminInicial();
                guardarEnArchivo();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Contar usuarios existentes
    private int contarUsuarios() {
        int c = 0;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                c++;
            }
        }
        return c;
    }

    // Crear admin automático
    private void crearAdminInicial() {
        usuarios[contador] = new Administrador("admin", "Administrador", "IPC1");
        contador++;
    }

    // Guardar archivo
    public void guardarEnArchivo() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
            out.writeObject(usuarios);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CRUD básico
    public void agregar(Usuario u) {
        usuarios[contador] = u;
        contador++;
        guardarEnArchivo();
    }

    public Usuario buscar(String codigo, String password) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getCodigo().equals(codigo)
                    && usuarios[i].getPassword().equals(password)) {
                return usuarios[i];
            }
        }
        return null;
    }

    public Usuario buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i] != null && usuarios[i].getCodigo().equals(codigo)) {
                return usuarios[i];
            }
        }
        return null;
    }
}
