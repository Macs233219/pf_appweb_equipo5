/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import fachada.FachadaAccesoDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Municipio;
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
public class Registrarse extends HttpServlet {

   

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
        
        // Se obtienen los datos del formulario
        String nombres = request.getParameter("nombres");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
//        String estado = request.getParameter("estado");
        String municipioString = request.getParameter("municipio");
        String genero = request.getParameter("genero");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String contrasena = request.getParameter("contrasena");
        String ciudad = request.getParameter("ciudad");
        
        String nombreCompleto = nombres + " " + apellidos;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fecha = null;
        
        try {
            fecha = sdf.parse(fechaNacimiento);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        
        FachadaAccesoDatos fad = new FachadaAccesoDatos();
        
        List<Municipio> listaMunicipios = fad.obtenerMunicipios();
        Municipio municipio = null;
        
        for (Municipio elementoMunicipio: listaMunicipios) {
            if (municipioString.equals(elementoMunicipio.getNombre())) {
                municipio = elementoMunicipio;
            }
        }
        
        fad.crearUsuarioNormal(new UsuarioNormal(nombreCompleto, usuario, correo, contrasena, telefono, "imagen.png", ciudad, fecha, genero, municipio));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        
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
