/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.UsuarioAdministrador;

/**
 *
 * @author marlon
 */
public class UsuarioAdministradorJpaController implements Serializable {

    public UsuarioAdministradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioAdministrador usuarioAdministrador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioAdministrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioAdministrador usuarioAdministrador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioAdministrador = em.merge(usuarioAdministrador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuarioAdministrador.getId();
                if (findUsuarioAdministrador(id) == null) {
                    throw new NonexistentEntityException("The usuarioAdministrador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioAdministrador usuarioAdministrador;
            try {
                usuarioAdministrador = em.getReference(UsuarioAdministrador.class, id);
                usuarioAdministrador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioAdministrador with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioAdministrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioAdministrador> findUsuarioAdministradorEntities() {
        return findUsuarioAdministradorEntities(true, -1, -1);
    }

    public List<UsuarioAdministrador> findUsuarioAdministradorEntities(int maxResults, int firstResult) {
        return findUsuarioAdministradorEntities(false, maxResults, firstResult);
    }

    private List<UsuarioAdministrador> findUsuarioAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioAdministrador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public UsuarioAdministrador findUsuarioAdministrador(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioAdministrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioAdministrador> rt = cq.from(UsuarioAdministrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
