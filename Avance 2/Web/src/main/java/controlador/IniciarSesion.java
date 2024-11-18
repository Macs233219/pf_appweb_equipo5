/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import fachada.FachadaAccesoDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        
        // Se obtienen las credenciales ingresadas por el usuario
        String email = request.getParameter("email");
        String password = request.getParameter("contrasena");
        
        // Se verifica la coincidencia con credenciales de la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlogPU");
        FachadaAccesoDatos fad = new FachadaAccesoDatos();
        
        
        List<Usuario> usersDB = fad.obtenerUsuarios();
        
        for (Usuario usuario: usersDB) {
            if (email.equals(usuario.getCorreo())) {
                
            }
        }
        
//        if ("admin".equals(username) && "12345".equals(password)) {
//            HttpSession sesion = request.getSession();
//            sesion.setAttribute("usuario", username);
//            response.sendRedirect(request.getContextPath() + "/home.jsp");
//        } else {
//            response.sendRedirect(request.getContextPath() + "/index.jsp?error=true");
//        }
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
