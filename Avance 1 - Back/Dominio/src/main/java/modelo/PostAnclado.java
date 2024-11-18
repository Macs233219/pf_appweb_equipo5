/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author marlon
 */
@Entity
public class PostAnclado extends Post {
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioAdministrador usuarioAdministrador;

    public PostAnclado() {
    }

    public PostAnclado(UsuarioAdministrador usuarioAdministrador, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuarioAdministrador = usuarioAdministrador;
    }

    public UsuarioAdministrador getUsuarioAdministrador() {
        return usuarioAdministrador;
    }

    public void setUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
        this.usuarioAdministrador = usuarioAdministrador;
    }
    
}
