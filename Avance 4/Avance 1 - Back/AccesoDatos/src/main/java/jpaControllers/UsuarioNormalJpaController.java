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
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
public class UsuarioNormalJpaController implements Serializable {

    public UsuarioNormalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioNormal usuarioNormal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioNormal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioNormal usuarioNormal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioNormal = em.merge(usuarioNormal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuarioNormal.getId();
                if (findUsuarioNormal(id) == null) {
                    throw new NonexistentEntityException("The usuarioNormal with id " + id + " no longer exists.");
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
            UsuarioNormal usuarioNormal;
            try {
                usuarioNormal = em.getReference(UsuarioNormal.class, id);
                usuarioNormal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioNormal with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioNormal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioNormal> findUsuarioNormalEntities() {
        return findUsuarioNormalEntities(true, -1, -1);
    }

    public List<UsuarioNormal> findUsuarioNormalEntities(int maxResults, int firstResult) {
        return findUsuarioNormalEntities(false, maxResults, firstResult);
    }

    private List<UsuarioNormal> findUsuarioNormalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioNormal.class));
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

    public UsuarioNormal findUsuarioNormal(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioNormal.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioNormalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioNormal> rt = cq.from(UsuarioNormal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
