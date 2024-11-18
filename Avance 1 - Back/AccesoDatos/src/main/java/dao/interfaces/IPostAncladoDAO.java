/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.PostAnclado;

/**
 *
 * @author marlon
 */
public interface IPostAncladoDAO {
    
    PostAnclado obtenerPostAncladoPorId(Long id);
    List<PostAnclado> obtenerPostAnclados();
    void crearPostAnclado(PostAnclado post);
    void editarPostAnclado(PostAnclado post);
    void eliminarPostAnclado(Long id);
    
}
