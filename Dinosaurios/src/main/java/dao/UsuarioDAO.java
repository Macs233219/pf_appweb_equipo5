/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.JPAFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO {

    public void crearUsuario(Usuario usuario) {
        EntityManager em = JPAFactory.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        EntityManager em = JPAFactory.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        EntityManager em = JPAFactory.getEntityManager();
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        em.close();
        return usuarios;
    }
}
