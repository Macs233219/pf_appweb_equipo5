/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PostComun extends Post {

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public PostComun() {
    }

    public PostComun(Usuario usuario, Long id, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion, String portada, List<Comentario> comentarios) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion, portada, comentarios);
        this.usuario = usuario;
    }

    public PostComun(Usuario usuario, Long id, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion, String portada) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion, portada);
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
