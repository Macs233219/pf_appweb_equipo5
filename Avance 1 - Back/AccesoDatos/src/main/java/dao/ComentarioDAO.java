/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IComentarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.ComentarioJpaController;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.Comentario;

/**
 *
 * @author marlon
 */
public class ComentarioDAO implements IComentarioDAO {
    
    private ComentarioJpaController comentarioJpaController;

    public ComentarioDAO() {
        this.comentarioJpaController = new ComentarioJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public Comentario obtenerComentarioPorId(Long id) {
        return this.comentarioJpaController.findComentario(id);
    }

    @Override
    public List<Comentario> obtenerComentarios() {
        return this.comentarioJpaController.findComentarioEntities();
    }

    @Override
    public void crearComentario(Comentario comentario) {
        this.comentarioJpaController.create(comentario);
    }

    @Override
    public void editarComentario(Comentario comentario) {
        try {
            this.comentarioJpaController.edit(comentario);
        } catch (Exception ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarComentario(Long id) {
        try {
            this.comentarioJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
