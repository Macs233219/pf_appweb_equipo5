/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import encriptacion.PasswordEncryption;
import fachada.FachadaAccesoDatos;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author marlon
 */
public class IniciarSesion extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // OBTENER CREDENCIALES INGRESADAS
        String username = request.getParameter("usuario");
        String password = request.getParameter("contrasena");
        
        // CONEXIÓN A BASE DE DATOS
        FachadaAccesoDatos fad = new FachadaAccesoDatos();
        List<Usuario> usersDB = fad.obtenerUsuarios();
        
        // ENCRIPTAR CONTRASENIA
        String contrasenaEncriptada = PasswordEncryption.encryptPassword(password);
        
        
        
        // AUTENTICAR
        Long id = 0L;
        boolean autenticado = false;
        for (Usuario usuario: usersDB) {
            if (username.equals(usuario.getNombreUsuario()) && contrasenaEncriptada.equals(usuario.getContrasenia())) {
                autenticado = true;
                id = usuario.getId();
                break;
            }
        }
        
        boolean esAdmin = id == 4;
        
        HttpSession sesion = request.getSession();
        
        if (autenticado) {
            // se agrega el nombre de usuario y su valor identificador a la sesión
            sesion.setAttribute("idUsuario", id);
            sesion.setAttribute("usuario", username);
        }
        
        if (esAdmin) {
            sesion.setAttribute("esAdmin", "admin");
        }
        
        
        // DIRIGIR A PÁGINAS
        if (autenticado && esAdmin) {
            request.setAttribute("listaPublicaciones", fad.obtenerPostsComunes());
            RequestDispatcher dispatcher = request.getRequestDispatcher("administrarPublicaciones.jsp");
            dispatcher.forward(request, response);
        } else if (autenticado && !esAdmin) {
            sesion.setAttribute("esAdmin", null);
            request.setAttribute("listaPublicaciones", fad.obtenerPostsComunes());
            RequestDispatcher dispatcher = request.getRequestDispatcher("verPublicaciones.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp?error=true");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
