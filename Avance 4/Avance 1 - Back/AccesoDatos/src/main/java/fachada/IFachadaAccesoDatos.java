/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import java.util.List;
import modelo.Comentario;
import modelo.Estado;
import modelo.Municipio;
import modelo.Post;
import modelo.PostAnclado;
import modelo.PostComun;
import modelo.Usuario;
import modelo.UsuarioAdministrador;
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
public interface IFachadaAccesoDatos {
    
    Comentario obtenerComentarioPorId(Long id);
    List<Comentario> obtenerComentarios();
    void crearComentario(Comentario comentario);
    void editarComentario(Comentario comentario);
    void eliminarComentario(Long id);
    
    Estado obtenerEstadoPorId(Long id);
    List<Estado> obtenerEstados();
    void crearEstado(Estado estado);
    void editarEstado(Estado estado);
    void eliminarEstado(Long id);
    
    Municipio obtenerMunicipioPorId(Long id);
    List<Municipio> obtenerMunicipios();
    void crearMunicipio(Municipio municipio);
    void editarMunicipio(Municipio municipio);
    void eliminarMunicipio(Long id);
    
    PostAnclado obtenerPostAncladoPorId(Long id);
    List<PostAnclado> obtenerPostAnclados();
    void crearPostAnclado(PostAnclado post);
    void editarPostAnclado(PostAnclado post);
    void eliminarPostAnclado(Long id);
    
    PostComun obtenerPostComunPorId(Long id);
    List<PostComun> obtenerPostsComunes();
    void crearPostComun(PostComun post);
    void editarPPostComun(PostComun post);
    void eliminarPostComun(Long id);
    
    Post obtenerPostPorId(Long id);
    List<Post> obtenerPosts();
    void crearPost(Post post);
    void editarPost(Post post);
    void eliminarPost(Long id);
    
    UsuarioAdministrador obtenerUsuarioAdministradorPorId(Long id);
    List<UsuarioAdministrador> obtenerUsuariosAdministradores();
    void crearUsuarioAdministrador(UsuarioAdministrador usuario);
    void editarUsuarioAdministrador(UsuarioAdministrador usuario);
    void eliminarUsuarioAdministrador(Long id);
    
    Usuario obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerUsuarios();
    void crearUsuario(Usuario usuario);
    void editarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
    
    UsuarioNormal obtenerUsuarioNormalPorId(Long id);
    List<UsuarioNormal> obtenerUsuariosNormales();
    void crearUsuarioNormal(UsuarioNormal usuario);
    void editarUsuarioNormal(UsuarioNormal usuario);
    void eliminarUsuarioNormal(Long id);
    
}
