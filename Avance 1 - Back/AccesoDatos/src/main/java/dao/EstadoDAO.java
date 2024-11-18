/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IEstadoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.EstadoJpaController;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.Estado;

/**
 *
 * @author marlon
 */
public class EstadoDAO implements IEstadoDAO {
    
    private EstadoJpaController estadoJpaController;

    public EstadoDAO() {
         estadoJpaController = new EstadoJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public Estado obtenerEstadoPorId(Long id) {
        return this.estadoJpaController.findEstado(id);
    }

    @Override
    public List<Estado> obtenerEstados() {
        return this.estadoJpaController.findEstadoEntities();
    }

    @Override
    public void crearEstado(Estado estado) {
        this.estadoJpaController.create(estado);
    }

    @Override
    public void editarEstado(Estado estado) {
        try {
            this.estadoJpaController.edit(estado);
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarEstado(Long id) {
        try {
            this.estadoJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
