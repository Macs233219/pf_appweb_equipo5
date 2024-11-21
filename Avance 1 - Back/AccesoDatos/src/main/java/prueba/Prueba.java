/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import fachada.FachadaAccesoDatos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jpaControllers.EstadoJpaController;
import jpaControllers.MunicipioJpaController;
import jpaControllers.UsuarioJpaController;
import jpaControllers.UsuarioNormalJpaController;
import java.util.Date;
import java.util.List;
import modelo.Comentario;
import modelo.Estado;
import modelo.Municipio;
import modelo.Post;
import modelo.PostComun;
import modelo.Usuario;
import modelo.UsuarioAdministrador;
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
public class Prueba {
    
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlogPU");
        
//        EstadoJpaController estadoDao = new EstadoJpaController(emf);
//        MunicipioJpaController municipioDao = new MunicipioJpaController(emf);
//        UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
//        UsuarioNormalJpaController usuarioNormalDao = new UsuarioNormalJpaController(emf);
        
        FachadaAccesoDatos fad = new FachadaAccesoDatos();
        Date fecha = new Date();
        


//      ----------------
//      CREAR ESTADO
//      ----------------

//        fad.crearEstado(new Estado("Sonora"));
//        fad.crearEstado(new Estado("Jalisco"));
//        fad.crearEstado(new Estado("Chiapas"));
//        fad.crearEstado(new Estado("Guerrero"));
        

//      ----------------
//      CREAR MUNICIPIO
//      ----------------

//        fad.crearMunicipio(new Municipio("Cajeme", fad.obtenerEstadoPorId(1L)));
//        fad.crearMunicipio(new Municipio("Hermosillo", fad.obtenerEstadoPorId(1L)));
//        fad.crearMunicipio(new Municipio("Sauaripa", fad.obtenerEstadoPorId(1L)));


//        List<Municipio> municipios = fad.obtenerMunicipios();
//        for (Municipio municipio: municipios) {
//            System.out.println(municipio.getNombre());
//        }

//      ----------------
//      CREAR USUARIO
//      ----------------

//        String contraseniaEncriptada = "root";
//
//        try {
//            // Crear la instancia de MessageDigest con el algoritmo SHA-256
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//
//            // Aplicar el algoritmo de hash a la contraseña
//            byte[] hashedPassword = md.digest(contraseniaEncriptada.getBytes());
//
//            // Convertir el hash en una cadena hexadecimal
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hashedPassword) {
//                sb.append(String.format("%02x", b));
//            }
//            contraseniaEncriptada = sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//
//        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador("Pedro Torres", "admin", "admin@mail.com", contraseniaEncriptada, "2222334455", "imagen.png", "Obregón", fecha, "mascuilino", fad.obtenerMunicipioPorId(1L));
//        fad.crearUsuarioAdministrador(usuarioAdministrador);

//      ----------------
//      CREAR POST COMUN
//      ----------------

//        UsuarioNormal usuarioNormal = fad.obtenerUsuarioNormalPorId(3L);
//        
//        PostComun postComun = new PostComun(usuarioNormal, null, fecha, "Dinosaurios Favoritos", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", fecha);        
//
//        fad.crearPostComun(postComun);
        
//      ----------------
//      CREAR COMENTARIO
//      ----------------

//        UsuarioNormal usuarioNormal = fad.obtenerUsuarioNormalPorId(2L);
//        
//        PostComun postComun = fad.obtenerPostComunPorId(3L);
//        
//        fad.crearComentario(new Comentario(fecha, "Mi dinosaurio favorito es el cuello largo.", postComun, usuarioNormal));

    }
    
}
