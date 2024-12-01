/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import encriptacion.PasswordEncryption;
import fachada.FachadaAccesoDatos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Municipio;
import modelo.Usuario;
import modelo.UsuarioNormal;

/**
 *
 * @author marlon
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 16,
        maxRequestSize = 1024 * 1024 * 16)
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

        // OBTENER DATOS DEL FORMULARIO
        String nombres = request.getParameter("nombres");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String municipioString = request.getParameter("municipio");
        String genero = request.getParameter("genero");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String contrasena = request.getParameter("contrasena");
        String ciudad = request.getParameter("ciudad");

        // Ruta para guardar imágenes
        String uploadPath = "C:\\Users\\Jose Pablo\\Desktop\\BlogDinosaurios\\src\\main\\webapp\\avatares";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Part avatarPart = request.getPart("imagen-avatar");
        String fileName = Paths.get(avatarPart.getSubmittedFileName()).getFileName().toString();
        String filePath = uploadPath + File.separator + fileName;

        System.out.println("Ruta: " + uploadPath);

        // Guardar archivo
        avatarPart.write(filePath);

        // ENCRIPTAR CONTRASENIA
        String contrasenaEncriptada = PasswordEncryption.encryptPassword(contrasena);

        // FORMATO PARA FECHA Y NOMBRE COMPLETO
        String nombreCompleto = nombres + " " + apellidos;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaNacimiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // CONEXIÓN A BD
        FachadaAccesoDatos fad = new FachadaAccesoDatos();

        // BANDERA DE REGISTRO
        boolean registrar = true;

        // VERIFICAR NOMBRE DE USUARIO NO REPETIDO
        List<Usuario> usuariosBD = fad.obtenerUsuarios();
        for (Usuario usuarioBD : usuariosBD) {
            if (usuario.equals(usuarioBD.getNombreUsuario())) {
                registrar = false;
                System.out.println("NOMBRE DE USUARIO REPETIDO");
            }

            if (correo.equals(usuarioBD.getCorreo())) {
                registrar = false;
                System.out.println("CORREO REPETIDO");
            }
        }

        // IDENTIFICAR MUNICIPIO
        List<Municipio> listaMunicipios = fad.obtenerMunicipios();
        Municipio municipio = null;
        for (Municipio elementoMunicipio : listaMunicipios) {
            if (municipioString.equals(elementoMunicipio.getNombre())) {
                municipio = elementoMunicipio;
            }
        }

        // CREAR USUARIO
        if (registrar) {
            fad.crearUsuarioNormal(new UsuarioNormal(nombreCompleto, usuario, correo, contrasenaEncriptada, telefono, fileName, ciudad, fecha, genero, municipio));
        }

        // DIRIGIR A PÁGINA DE INICIO
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
