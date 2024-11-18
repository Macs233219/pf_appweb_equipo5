/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import dao.ComentarioDAO;
import dao.EstadoDAO;
import dao.MunicipioDAO;
import dao.PostAncladoDAO;
import dao.PostComunDAO;
import dao.PostDAO;
import dao.UsuarioAdministradorDAO;
import dao.UsuarioDAO;
import dao.UsuarioNormalDAO;
import dao.interfaces.IComentarioDAO;
import dao.interfaces.IEstadoDAO;
import dao.interfaces.IMunicipioDAO;
import dao.interfaces.IPostAncladoDAO;
import dao.interfaces.IPostComunDAO;
import dao.interfaces.IPostDAO;
import dao.interfaces.IUsuarioAdministradorDAO;
import dao.interfaces.IUsuarioDAO;
import dao.interfaces.IUsuarioNormalDAO;

/**
 *
 * @author marlon
 */
public class DaoFactory {
    
    public static IComentarioDAO getComentarioDAO() {
        return new ComentarioDAO();
    }
    
    public static IEstadoDAO getEstadoDAO() {
        return new EstadoDAO();
    }
    
    public static IMunicipioDAO getMunicipioDAO() {
        return new MunicipioDAO();
    }
    
    public static IPostAncladoDAO getPostAncladoDAO() {
        return new PostAncladoDAO();
    }
    
    public static IPostComunDAO getPostComunDAO() {
        return new PostComunDAO();
    }
    
    public static IPostDAO getPostDAO() {
        return new PostDAO();
    }
    
    public static IUsuarioAdministradorDAO getUsuarioAdministradorDAO() {
        return new UsuarioAdministradorDAO();
    }
    
    public static IUsuarioNormalDAO getUsuarioNormalDAO() {
        return new UsuarioNormalDAO();
    }
    
    public static IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
    
}
