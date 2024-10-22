/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.UsuarioAdministradorJpaController;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.UsuarioAdministrador;
import dao.interfaces.IUsuarioAdministradorDAO;

/**
 *
 * @author marlon
 */
public class UsuarioAdministradorDAO implements IUsuarioAdministradorDAO {
    
    private UsuarioAdministradorJpaController usuarioAdministradorJpaController;

    public UsuarioAdministradorDAO() {
        this.usuarioAdministradorJpaController = new UsuarioAdministradorJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public UsuarioAdministrador obtenerUsuarioAdministradorPorId(Long id) {
        return this.usuarioAdministradorJpaController.findUsuarioAdministrador(id);
    }

    @Override
    public List<UsuarioAdministrador> obtenerUsuariosAdministradores() {
        return this.usuarioAdministradorJpaController.findUsuarioAdministradorEntities();
    }

    @Override
    public void crearUsuarioAdministrador(UsuarioAdministrador usuario) {
        this.usuarioAdministradorJpaController.create(usuario);
    }

    @Override
    public void editarUsuarioAdministrador(UsuarioAdministrador usuario) {
        try {
            this.usuarioAdministradorJpaController.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioAdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarUsuarioAdministrador(Long id) {
        try {
            this.usuarioAdministradorJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioAdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
