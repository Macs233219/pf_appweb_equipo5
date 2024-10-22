/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.Municipio;

/**
 *
 * @author marlon
 */
public interface IMunicipioDAO {
    
    Municipio obtenerMunicipioPorId(Long id);
    List<Municipio> obtenerMunicipios();
    void crearMunicipio(Municipio municipio);
    void editarMunicipio(Municipio municipio);
    void eliminarMunicipio(Long id);
    
}
