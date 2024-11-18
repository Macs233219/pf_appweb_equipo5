/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import dao.ComentarioDAO;
import dao.EstadoDAO;
import dao.MunicipioDAO;
import dao.PostAncladoDAO;
import dao.PostComunDAO;
import dao.PostDAO;
import dao.UsuarioAdministradorDAO;
import dao.UsuarioDAO;
import dao.UsuarioNormalDAO;
import factory.DaoFactory;
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
public class FachadaAccesoDatos implements IFachadaAccesoDatos {

    private ComentarioDAO comentarioDAO;
    private EstadoDAO estadoDAO;
    private MunicipioDAO municipioDAO;
    private PostAncladoDAO postAncladoDAO;
    private PostComunDAO postComunDAO;
    private PostDAO postDAO;
    private UsuarioAdministradorDAO usuarioAdministradorDAO;
    private UsuarioDAO usuarioDAO;
    private UsuarioNormalDAO usuarioNormalDAO;
    
    public FachadaAccesoDatos() {
        this.comentarioDAO = (ComentarioDAO) DaoFactory.getComentarioDAO();
        this.estadoDAO = (EstadoDAO) DaoFactory.getEstadoDAO();
        this.municipioDAO = (MunicipioDAO) DaoFactory.getMunicipioDAO();
        this.postAncladoDAO = (PostAncladoDAO) DaoFactory.getPostAncladoDAO();
        this.postComunDAO = (PostComunDAO) DaoFactory.getPostComunDAO();
        this.postDAO = (PostDAO) DaoFactory.getPostDAO();
        this.usuarioAdministradorDAO = (UsuarioAdministradorDAO) DaoFactory.getUsuarioAdministradorDAO();
        this.usuarioDAO = (UsuarioDAO) DaoFactory.getUsuarioDAO();
        this.usuarioNormalDAO = (UsuarioNormalDAO) DaoFactory.getUsuarioNormalDAO();
    }

    @Override
    public Comentario obtenerComentarioPorId(Long id) {
        return this.comentarioDAO.obtenerComentarioPorId(id);
    }

    @Override
    public List<Comentario> obtenerComentarios() {
        return this.comentarioDAO.obtenerComentarios();
    }

    @Override
    public void crearComentario(Comentario comentario) {
        this.comentarioDAO.crearComentario(comentario);
    }

    @Override
    public void editarComentario(Comentario comentario) {
        this.comentarioDAO.editarComentario(comentario);
    }

    @Override
    public void eliminarComentario(Long id) {
        this.comentarioDAO.eliminarComentario(id);
    }

    @Override
    public Estado obtenerEstadoPorId(Long id) {
        return this.estadoDAO.obtenerEstadoPorId(id);
    }

    @Override
    public List<Estado> obtenerEstados() {
        return this.estadoDAO.obtenerEstados();
    }

    @Override
    public void crearEstado(Estado estado) {
        this.estadoDAO.crearEstado(estado);
    }

    @Override
    public void editarEstado(Estado estado) {
        this.estadoDAO.editarEstado(estado);
    }

    @Override
    public void eliminarEstado(Long id) {
        this.estadoDAO.eliminarEstado(id);
    }

    @Override
    public Municipio obtenerMunicipioPorId(Long id) {
        return this.municipioDAO.obtenerMunicipioPorId(id);
    }

    @Override
    public List<Municipio> obtenerMunicipios() {
        return this.municipioDAO.obtenerMunicipios();
    }

    @Override
    public void crearMunicipio(Municipio municipio) {
        this.municipioDAO.crearMunicipio(municipio);
    }

    @Override
    public void editarMunicipio(Municipio municipio) {
        this.municipioDAO.editarMunicipio(municipio);
    }

    @Override
    public void eliminarMunicipio(Long id) {
        this.municipioDAO.eliminarMunicipio(id);
    }

    @Override
    public PostAnclado obtenerPostAncladoPorId(Long id) {
        return this.postAncladoDAO.obtenerPostAncladoPorId(id);
    }

    @Override
    public List<PostAnclado> obtenerPostAnclados() {
        return this.postAncladoDAO.obtenerPostAnclados();
    }

    @Override
    public void crearPostAnclado(PostAnclado post) {
        this.postAncladoDAO.crearPostAnclado(post);
    }

    @Override
    public void editarPostAnclado(PostAnclado post) {
        this.postAncladoDAO.editarPostAnclado(post);
    }

    @Override
    public void eliminarPostAnclado(Long id) {
        this.postAncladoDAO.eliminarPostAnclado(id);
    }

    @Override
    public PostComun obtenerPostComunPorId(Long id) {
        return this.postComunDAO.obtenerPostComunPorId(id);
    }

    @Override
    public List<PostComun> obtenerPostsComunes() {
        return this.postComunDAO.obtenerPostsComunes();
    }

    @Override
    public void crearPostComun(PostComun post) {
        this.postComunDAO.crearPostComun(post);
    }

    @Override
    public void editarPPostComun(PostComun post) {
        this.postComunDAO.editarPPostComun(post);
    }

    @Override
    public void eliminarPostComun(Long id) {
        this.postAncladoDAO.eliminarPostAnclado(id);
    }

    @Override
    public Post obtenerPostPorId(Long id) {
        return this.postDAO.obtenerPostPorId(id);
    }

    @Override
    public List<Post> obtenerPosts() {
        return this.postDAO.obtenerPosts();
    }

    @Override
    public void crearPost(Post post) {
        this.postDAO.crearPost(post);
    }

    @Override
    public void editarPost(Post post) {
        this.postDAO.editarPost(post);
    }

    @Override
    public void eliminarPost(Long id) {
        this.postDAO.eliminarPost(id);
    }

    @Override
    public UsuarioAdministrador obtenerUsuarioAdministradorPorId(Long id) {
        return this.usuarioAdministradorDAO.obtenerUsuarioAdministradorPorId(id);
    }

    @Override
    public List<UsuarioAdministrador> obtenerUsuariosAdministradores() {
        return this.usuarioAdministradorDAO.obtenerUsuariosAdministradores();
    }

    @Override
    public void crearUsuarioAdministrador(UsuarioAdministrador usuario) {
        this.usuarioAdministradorDAO.crearUsuarioAdministrador(usuario);
    }

    @Override
    public void editarUsuarioAdministrador(UsuarioAdministrador usuario) {
        this.usuarioAdministradorDAO.editarUsuarioAdministrador(usuario);
    }

    @Override
    public void eliminarUsuarioAdministrador(Long id) {
        this.usuarioAdministradorDAO.eliminarUsuarioAdministrador(id);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return this.usuarioDAO.obtenerUsuarioPorId(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return this.usuarioDAO.obtenerUsuarios();
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.usuarioDAO.crearUsuario(usuario);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        this.usuarioDAO.editarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        this.usuarioDAO.eliminarUsuario(id);
    }

    @Override
    public UsuarioNormal obtenerUsuarioNormalPorId(Long id) {
        return this.usuarioNormalDAO.obtenerUsuarioNormalPorId(id);
    }

    @Override
    public List<UsuarioNormal> obtenerUsuariosNormales() {
        return this.usuarioNormalDAO.obtenerUsuariosNormales();
    }

    @Override
    public void crearUsuarioNormal(UsuarioNormal usuario) {
        this.usuarioNormalDAO.crearUsuarioNormal(usuario);
    }

    @Override
    public void editarUsuarioNormal(UsuarioNormal usuario) {
        this.usuarioNormalDAO.editarUsuarioNormal(usuario);
    }

    @Override
    public void eliminarUsuarioNormal(Long id) {
        this.usuarioNormalDAO.eliminarUsuarioNormal(id);
    }
    
}
