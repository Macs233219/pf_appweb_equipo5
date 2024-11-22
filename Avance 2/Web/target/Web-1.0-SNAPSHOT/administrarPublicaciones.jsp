<%-- 
    Document   : administrarPublicaciones
    Created on : Nov 21, 2024, 2:26:07 PM
    Author     : marlon
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Dinosaurios</title>
        <link rel="stylesheet" href="./styles/administrarPublicaciones.css"/>
    </head>
    <body>
        <div class="container">
            <!-- Encabezado -->
            <header>
                <div class="custom-logo2">
                    <img src="imgs/logo-dinosaurio.png" alt="Logo personalizado">
                </div>
                <div class="search-bar">
                    <i class="fas fa-search"></i>
                    <input type="text" placeholder="Buscar">
                </div>
                <div class="profile">
                    <img src="imgs/avatar_1.png" alt="Perfil">
                    <span>Perfil</span>
                </div>
            </header>

            <div class="pinned-posts">


                <c:forEach var="publicacionAnclada" items="${publicacionesFijadas}">
                    <div class="post-item">
                        <i class="fas fa-thumbtack pinned-icon"></i> <!-- Icono de pin -->
                        <img src="imgs/7.jpg" alt="Dinosaurios Voladores">
                        <div class="post-content">
                            <h3>${publicacionAnclada.titulo}</h3>
                            <p>${publicacionAnclada.contenido}</p>
                            <span class="date">${publicacionAnclada.fechaHoraCreacion}</span>
                        </div>
                        <div class="post-info">
                            <div class="usuario">
                                <span>${publicacionAnclada.usuarioAdministrador.nombreUsuario}</span>
                                <img style="width: 45px; height: 45px;" src="imgs/avatar_0.png" alt="Usuario #4">
                            </div>
                            <div class="icons">
                                <i class="fas fa-share-alt"></i>
                            </div>
                        </div>



                    </div>
                </c:forEach>
            </div>



            <!-- Lista de publicaciones -->
            <div class="post-list">

                <c:forEach var="publicacion" items="${listaPublicaciones}">
                    <div class="post-item">
                        <img src="imgs/imagen_publicacion.jpg" alt="Tipos de Dinosaurios">
                        <div class="post-content">
                            <a href="VerPublicacion?id=${publicacion.id}"><h3>${publicacion.titulo}</h3></a>
                            <p>${publicacion.contenido}</p>
                            <span class="date">${publicacion.fechaHoraCreacion}</span>
                        </div>
                        <div class="post-info">
                            <div class="usuario"> 
                                <span>${publicacion.usuario.nombreUsuario}</span>
                                <img  style="
                                      width: 45px !important;
                                      height: 45px !important;" src="imgs/avatar_2.png" alt="Tipos de Dinosaurios">
                            </div>

                            <div class="icons">
                                <a href="EliminarPublicacion?id=${publicacion.id}">Eliminar</a>
                                <i class="fas fa-share-alt"></i>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <!-- Paginación -->
            <div class="pagination">
                <i class="fas fa-chevron-left"></i>
                <span>4</span>
                <i class="fas fa-chevron-right"></i>
            </div>
        </div>
    </body>
</html>
