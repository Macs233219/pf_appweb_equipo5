/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
public interface IUsuarioNormalDAO {
    
    UsuarioNormal obtenerUsuarioNormalPorId(Long id);
    List<UsuarioNormal> obtenerUsuariosNormales();
    void crearUsuarioNormal(UsuarioNormal usuario);
    void editarUsuarioNormal(UsuarioNormal usuario);
    void eliminarUsuarioNormal(Long id);
    
}
