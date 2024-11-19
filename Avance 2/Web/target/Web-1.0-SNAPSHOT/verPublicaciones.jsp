<%-- 
    Document   : verPublicaciones
    Created on : Nov 18, 2024, 4:11:13 PM
    Author     : marlon
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Dinosaurios</title>
    <link rel="stylesheet" href="./styles/verPublicacion.css"/>
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
                    <span>Usuario #2</span>
                    <img  style="
                    width: 45px !important;
                    height: 45px !important;" src="imgs/avatar_2.png" alt="Tipos de Dinosaurios">
                  </div>

                    <div class="icons">
                      <i class="fas fa-trash-alt fa-2x" style="color: #fe0b0b;"></i>
                        <i class="fas fa-share-alt"></i>
                        <i class="fas fa-thumbtack pinned-icon2"></i>
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

