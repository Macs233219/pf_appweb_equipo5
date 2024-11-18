/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import jpaControllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.PostAnclado;

/**
 *
 * @author marlon
 */
public class PostAncladoJpaController implements Serializable {

    public PostAncladoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PostAnclado postAnclado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(postAnclado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PostAnclado postAnclado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            postAnclado = em.merge(postAnclado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = postAnclado.getId();
                if (findPostAnclado(id) == null) {
                    throw new NonexistentEntityException("The postAnclado with id " + id + " no longer exists.");
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
            PostAnclado postAnclado;
            try {
                postAnclado = em.getReference(PostAnclado.class, id);
                postAnclado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The postAnclado with id " + id + " no longer exists.", enfe);
            }
            em.remove(postAnclado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PostAnclado> findPostAncladoEntities() {
        return findPostAncladoEntities(true, -1, -1);
    }

    public List<PostAnclado> findPostAncladoEntities(int maxResults, int firstResult) {
        return findPostAncladoEntities(false, maxResults, firstResult);
    }

    private List<PostAnclado> findPostAncladoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PostAnclado.class));
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

    public PostAnclado findPostAnclado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PostAnclado.class, id);
        } finally {
            em.close();
        }
    }

    public int getPostAncladoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PostAnclado> rt = cq.from(PostAnclado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
