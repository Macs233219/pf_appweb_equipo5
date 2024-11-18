/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IPostDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.PostJpaController;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.Post;

/**
 *
 * @author marlon
 */
public class PostDAO implements IPostDAO {
    
    private PostJpaController postJpaController;

    public PostDAO() {
        this.postJpaController = new PostJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public Post obtenerPostPorId(Long id) {
        return this.postJpaController.findPost(id);
    }

    @Override
    public List<Post> obtenerPosts() {
        return this.postJpaController.findPostEntities();
    }

    @Override
    public void crearPost(Post post) {
        this.postJpaController.create(post);
    }

    @Override
    public void editarPost(Post post) {
        try {
            this.postJpaController.edit(post);
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPost(Long id) {
        try {
            this.postJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
