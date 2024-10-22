/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author marlon
 */
public interface IUsuarioDAO {
    
    Usuario obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerUsuarios();
    void crearUsuario(Usuario usuario);
    void editarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
}
