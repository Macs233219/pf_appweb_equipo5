/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IPostComunDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.PostComunJpaController;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.PostComun;

/**
 *
 * @author marlon
 */
public class PostComunDAO implements IPostComunDAO {
    
    private PostComunJpaController postComunJpaController;

    public PostComunDAO() {
        this.postComunJpaController = new PostComunJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public PostComun obtenerPostComunPorId(Long id) {
        return this.postComunJpaController.findPostComun(id);
    }

    @Override
    public List<PostComun> obtenerPostsComunes() {
        return this.postComunJpaController.findPostComunEntities();
    }

    @Override
    public void crearPostComun(PostComun post) {
        this.postComunJpaController.create(post);
    }

    @Override
    public void editarPPostComun(PostComun post) {
        try {
            this.postComunJpaController.edit(post);
        } catch (Exception ex) {
            Logger.getLogger(PostComunDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPostComun(Long id) {
        try {
            this.postComunJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PostComunDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
