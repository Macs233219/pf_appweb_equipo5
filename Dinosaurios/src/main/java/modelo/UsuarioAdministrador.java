/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class UsuarioAdministrador extends Usuario {

    public UsuarioAdministrador() {
    }

    public UsuarioAdministrador(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, Municipio municipio) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, municipio);
    }
    
}
