/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.UsuarioAdministrador;

/**
 *
 * @author marlon
 */
public interface IUsuarioAdministradorDAO {
    
    UsuarioAdministrador obtenerUsuarioAdministradorPorId(Long id);
    List<UsuarioAdministrador> obtenerUsuariosAdministradores();
    void crearUsuarioAdministrador(UsuarioAdministrador usuario);
    void editarUsuarioAdministrador(UsuarioAdministrador usuario);
    void eliminarUsuarioAdministrador(Long id);
    
}
