/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHora;
    private String contenido;

    // Relación con Post y Usuario
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostComun postComun;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioNormal usuarioNormal;

    public Comentario() {
    }

    public Comentario(Date fechaHora, String contenido, PostComun postComun, UsuarioNormal usuarioNormal) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.postComun = postComun;
        this.usuarioNormal = usuarioNormal;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public PostComun getPost() {
        return postComun;
    }

    public void setPost(PostComun postComun) {
        this.postComun = postComun;
    }

    public UsuarioNormal getUsuario() {
        return usuarioNormal;
    }

    public void setUsuario(UsuarioNormal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }
    
}
