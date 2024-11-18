/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import fachada.FachadaAccesoDatos;
import jpaControllers.EstadoJpaController;
import jpaControllers.MunicipioJpaController;
import jpaControllers.UsuarioJpaController;
import jpaControllers.UsuarioNormalJpaController;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Estado;
import modelo.Municipio;
import modelo.Usuario;
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
public class Prueba {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlogPU");
        
        EstadoJpaController estadoDao = new EstadoJpaController(emf);
        MunicipioJpaController municipioDao = new MunicipioJpaController(emf);
        UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
        UsuarioNormalJpaController usuarioNormalDao = new UsuarioNormalJpaController(emf);
        
        FachadaAccesoDatos fad = new FachadaAccesoDatos();
        
        
        
        
//        Estado estado = new Estado("Sonora");
        
        
//        municipioDao.create(new Municipio("Cajeme", estadoDao.findEstado(1L)));
        
        Date fecha = new Date();
        
        Usuario usuario = new Usuario("Jorge Perez", "jorgito", "jperez@mail.com", "1234", "1122334455", "imagen.ong", "Obregón", fecha, "mascuilino", municipioDao.findMunicipio(1L));
        
        UsuarioNormal usuarioNormal = new UsuarioNormal("Jorge Perez", "jorgito", "jperez@mail.com", "1234", "1122334455", "imagen.ong", "Obregón", fecha, "mascuilino", municipioDao.findMunicipio(1L));
        
        fad.crearUsuarioNormal(usuarioNormal);
        
//        usuarioNormalDao.create(usuarioNormal);
        
//        usuarioDao.create(usuario);
        
//        estadoDao.create(estado);
        
        
        
        
        
        
    }
    
}
