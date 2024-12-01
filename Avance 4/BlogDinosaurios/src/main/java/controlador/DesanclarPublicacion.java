/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import fachada.FachadaAccesoDatos;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import modelo.Comentario;
import modelo.PostAnclado;
import modelo.PostComun;

/**
 *
 * @author Jose Pablo
 */
public class DesanclarPublicacion extends HttpServlet {

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
            out.println("<title>Servlet DesanclarPublicacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DesanclarPublicacion at " + request.getContextPath() + "</h1>");
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
//        String id = request.getParameter("id");
//
//        FachadaAccesoDatos fad = new FachadaAccesoDatos();
//
//        // OBTENER POST SIN ANCLAR
//        PostAnclado postAnclado = fad.obtenerPostAncladoPorId(Long.valueOf(id));
//
//        // CREAR OBJETO POST ANCLADO
//        PostComun postComun = new PostComun(postAnclado.getUsuario(), postAnclado.getId(), 
//                postAnclado.getFechaHoraCreacion(), postAnclado.getTitulo(), postAnclado.getTitulo(), 
//                postAnclado.getFechaHoraEdicion(), postAnclado.getPortada(), postAnclado.getComentarios());
//
//        //usuario, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion, portada
//        
//         // ELIMINAR COMENTARIOS;
//        for (Comentario comentario : postComun.getComentarios()) {
//            fad.eliminarComentario(comentario.getId());
//        }
//        // ELIMINAR POST ANCLADO
//        fad.eliminarPostAnclado(postAnclado.getId());
//        
//        // DESANCLAR POST
//        fad.crearPostComun(postComun);
//
//        request.setAttribute("listaPublicaciones", fad.obtenerPostsComunes());
//        request.setAttribute("publicacionesFijadas", fad.obtenerPostAnclados());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("administrarPublicaciones.jsp");
//        dispatcher.forward(request, response);

        String id = request.getParameter("id");

        FachadaAccesoDatos fad = new FachadaAccesoDatos();

        // OBTENER POST ANCLADO
        PostAnclado postAnclado = fad.obtenerPostAncladoPorId(Long.valueOf(id));

        // Crear el nuevo PostComun sin reutilizar el ID
        PostComun postComun = new PostComun(
                postAnclado.getUsuario(), null, postAnclado.getFechaHoraCreacion(), postAnclado.getTitulo(),
                postAnclado.getContenido(), postAnclado.getFechaHoraEdicion(), postAnclado.getPortada(),
                new ArrayList<>());

        // REASIGNAR COMENTARIOS
        for (Comentario comentario : postAnclado.getComentarios()) {
            comentario.setPost(postComun);
            postComun.getComentarios().add(comentario);
        }

        // PERSISTIR POST COMUN
        fad.crearPostComun(postComun);

        // PERSISTIR COMENTARIOS
        for (Comentario comentario : postComun.getComentarios()) {
            fad.editarComentario(comentario); // Actualizar cada comentario en la base de datos
        }

        // ELIMINAR POST ANCLADO
        fad.eliminarPostAnclado(postAnclado.getId());

        request.setAttribute("listaPublicaciones", fad.obtenerPostsComunes());
        request.setAttribute("publicacionesFijadas", fad.obtenerPostAnclados());
        RequestDispatcher dispatcher = request.getRequestDispatcher("administrarPublicaciones.jsp");
        dispatcher.forward(request, response);
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
        processRequest(request, response);
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
