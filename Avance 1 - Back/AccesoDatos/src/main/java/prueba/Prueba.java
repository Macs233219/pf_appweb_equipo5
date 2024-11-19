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
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Comentario;
import modelo.Estado;
import modelo.Municipio;
import modelo.Post;
import modelo.PostComun;
import modelo.Usuario;
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
public class Prueba {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlogPU");
        
//        EstadoJpaController estadoDao = new EstadoJpaController(emf);
//        MunicipioJpaController municipioDao = new MunicipioJpaController(emf);
//        UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
//        UsuarioNormalJpaController usuarioNormalDao = new UsuarioNormalJpaController(emf);
        
        FachadaAccesoDatos fad = new FachadaAccesoDatos();
        
        
        
        
//        Estado estado = new Estado("Sonora");
        
        
//        municipioDao.create(new Municipio("Cajeme", estadoDao.findEstado(1L)));
        
        Date fecha = new Date();
        
//        Usuario usuario = new Usuario("Jorge Perez", "jorgito", "jperez@mail.com", "1234", "1122334455", "imagen.ong", "Obregón", fecha, "mascuilino", municipioDao.findMunicipio(1L));
        
//        UsuarioNormal usuarioNormal = new UsuarioNormal("Pedro Torres", "pedrito", "ptorres@mail.com", "2345", "2222334455", "imagen.png", "Obregón", fecha, "mascuilino", municipioDao.findMunicipio(1L));
//        
//        fad.crearUsuarioNormal(usuarioNormal);
        
//        usuarioNormalDao.create(usuarioNormal);
        
//        usuarioDao.create(usuario);
        
//        estadoDao.create(estado);

//      ----------------
//      CREAR POST COMUN
//      ----------------

//        UsuarioNormal usuarioNormal = fad.obtenerUsuarioNormalPorId(15L);
//        
//        PostComun postComun = new PostComun(usuarioNormal, null, fecha, "Publicacion #1", "lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem", fecha);        
//
//        fad.crearPostComun(postComun);
        
//      ----------------
//      CREAR COMENTARIO
//      ----------------

//        UsuarioNormal usuarioNormal = fad.obtenerUsuarioNormalPorId(14L);
//        
//        PostComun postComun = fad.obtenerPostComunPorId(1L);
//        
//        fad.crearComentario(new Comentario(fecha, "Me gusta este post!", postComun, usuarioNormal));

//      ----------------
//      CREAR ESTADO
//      ----------------

//        fad.crearEstado(new Estado("Jalisco"));
        

//      ----------------
//      CREAR MUNICIPIO
//      ----------------

//        fad.crearMunicipio(new Municipio("Caborca", fad.obtenerEstadoPorId(1L)));


        List<Municipio> municipios = fad.obtenerMunicipios();
        for (Municipio municipio: municipios) {
            System.out.println(municipio.getNombre());
        }

    }
    
}
