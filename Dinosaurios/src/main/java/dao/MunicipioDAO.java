/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IMunicipioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.MunicipioJpaController;
import jpaControllers.exceptions.NonexistentEntityException;

/**
 *
 * @author marlon
 */
public class MunicipioDAO implements IMunicipioDAO {

    private MunicipioJpaController municipioJpaController;

    public MunicipioDAO() {
        this.municipioJpaController = new MunicipioJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }
    
    @Override
    public modelo.Municipio obtenerMunicipioPorId(Long id) {
        return this.municipioJpaController.findMunicipio(id);
    }

    @Override
    public List<modelo.Municipio> obtenerMunicipios() {
        return this.municipioJpaController.findMunicipioEntities();
    }

    @Override
    public void crearMunicipio(modelo.Municipio municipio) {
        this.municipioJpaController.create(municipio);
    }

    @Override
    public void editarMunicipio(modelo.Municipio municipio) {
        try {
            this.municipioJpaController.edit(municipio);
        } catch (Exception ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarMunicipio(Long id) {
        try {
            this.municipioJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
