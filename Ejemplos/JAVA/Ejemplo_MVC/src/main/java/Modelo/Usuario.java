/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class Usuario implements Serializable {

    protected String codigo;
    protected String nombre;
    protected String password;
    protected String tipo;

    public Usuario(String codigo, String nombre, String password, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
    }
}
