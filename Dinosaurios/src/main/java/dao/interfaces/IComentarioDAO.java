/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.Comentario;

/**
 *
 * @author marlon
 */
public interface IComentarioDAO {
    
    Comentario obtenerComentarioPorId(Long id);
    List<Comentario> obtenerComentarios();
    void crearComentario(Comentario comentario);
    void editarComentario(Comentario comentario);
    void eliminarComentario(Long id);
    
}
