/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Hector
 */
@Entity
public class UsuarioNormal extends Usuario {

    public UsuarioNormal() {
    }

    public UsuarioNormal(String nombreCompleto, String nombreUusario, String correo, String contrasenia, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, Municipio municipio) {
        super(nombreCompleto, nombreUusario, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, municipio);
    }
    
}
