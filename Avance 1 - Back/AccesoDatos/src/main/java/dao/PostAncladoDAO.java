/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IPostAncladoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.PostAncladoJpaController;
import jpaControllers.exceptions.NonexistentEntityException;

/**
 *
 * @author marlon
 */
public class PostAncladoDAO implements IPostAncladoDAO {
    
    private PostAncladoJpaController postAncladoJpaController;

    public PostAncladoDAO() {
        this.postAncladoJpaController = new PostAncladoJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public modelo.PostAnclado obtenerPostAncladoPorId(Long id) {
        return this.postAncladoJpaController.findPostAnclado(id);
    }

    @Override
    public List<modelo.PostAnclado> obtenerPostAnclados() {
        return this.postAncladoJpaController.findPostAncladoEntities();
    }

    @Override
    public void crearPostAnclado(modelo.PostAnclado post) {
        this.postAncladoJpaController.create(post);
    }

    @Override
    public void editarPostAnclado(modelo.PostAnclado post) {
        try {
            this.postAncladoJpaController.edit(post);
        } catch (Exception ex) {
            Logger.getLogger(PostAncladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPostAnclado(Long id) {
        try {
            this.postAncladoJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PostAncladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
