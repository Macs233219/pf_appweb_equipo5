/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IUsuarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.UsuarioJpaController;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.Usuario;

/**
 *
 * @author marlon
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private UsuarioJpaController usuarioJpaController;

    public UsuarioDAO() {
        this.usuarioJpaController = new UsuarioJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return this.usuarioJpaController.findUsuario(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return this.usuarioJpaController.findUsuarioEntities();
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.usuarioJpaController.create(usuario);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        try {
            this.usuarioJpaController.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        try {
            this.usuarioJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
