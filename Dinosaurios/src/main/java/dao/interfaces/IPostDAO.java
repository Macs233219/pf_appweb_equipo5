/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.Post;

/**
 *
 * @author marlon
 */
public interface IPostDAO {
    
    Post obtenerPostPorId(Long id);
    List<Post> obtenerPosts();
    void crearPost(Post post);
    void editarPost(Post post);
    void eliminarPost(Long id);
    
}
