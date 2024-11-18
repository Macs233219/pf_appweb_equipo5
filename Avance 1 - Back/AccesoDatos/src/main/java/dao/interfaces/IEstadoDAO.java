/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import modelo.Estado;

/**
 *
 * @author marlon
 */
public interface IEstadoDAO {
    
    Estado obtenerEstadoPorId(Long id);
    List<Estado> obtenerEstados();
    void crearEstado(Estado estado);
    void editarEstado(Estado estado);
    void eliminarEstado(Long id);
    
}
