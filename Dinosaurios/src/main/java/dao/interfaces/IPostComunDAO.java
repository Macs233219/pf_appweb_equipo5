/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.PostComun;

/**
 *
 * @author marlon
 */
public interface IPostComunDAO {
    
    PostComun obtenerPostComunPorId(Long id);
    List<PostComun> obtenerPostsComunes();
    void crearPostComun(PostComun post);
    void editarPPostComun(PostComun post);
    void eliminarPostComun(Long id);
    
}
