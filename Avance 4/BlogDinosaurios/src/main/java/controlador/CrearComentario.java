/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fachada.FachadaAccesoDatos;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import modelo.Comentario;
import modelo.Post;
import modelo.PostComun;
import modelo.Usuario;
import modelo.UsuarioNormal;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Jose Pablo
 */
public class CrearComentario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearComentario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearComentario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        HttpSession session = request.getSession(false);
        FachadaAccesoDatos fad = new FachadaAccesoDatos();
        Gson gson = new Gson();

        try {
            System.out.println("Cometario 1");
            String body = IOUtils.toString(request.getInputStream(), "utf-8");
            
            Comentario comentario = gson.fromJson(body, Comentario.class);

            UsuarioNormal usuario = fad.obtenerUsuarioNormalPorId((Long) session.getAttribute("idUsuario"));
            Post post = fad.obtenerPostPorId((Long) session.getAttribute("publicacionActualId"));
            
            System.out.println(post.getId() + " " + post.getTitulo());
            System.out.println(usuario.getId() + " " + usuario.getNombreUsuario());
            
            Date fechaHoraCreacion = new Date();
            comentario.setFechaHora(fechaHoraCreacion);
            
            comentario.setUsuario(usuario);
            comentario.setPost(post);
            
            System.out.println(comentario.getContenido());
            System.out.println(comentario.getPost().getTitulo());
            
            fad.crearComentario(comentario);

            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("status", "success");
            jsonResponse.addProperty("message", "Post creado con éxito");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(gson.toJson(jsonResponse));

        } catch (Exception e) {
            JsonObject errorResponse = new JsonObject();
            errorResponse.addProperty("status", "error");
            errorResponse.addProperty("message", "Hubo un error al crear el post: " + e.getMessage());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(gson.toJson(errorResponse));
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
