/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pablo
 */
public class Instructor extends Usuario {

    public Instructor(String codigo, String nombre, String password) {
        super(codigo, nombre, password, "INSTRUCTOR");
    }
}