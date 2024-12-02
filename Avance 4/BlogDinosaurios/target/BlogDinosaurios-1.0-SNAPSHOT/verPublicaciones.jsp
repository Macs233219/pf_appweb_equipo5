<%-- 
    Document   : verPublicaciones
    Created on : Nov 18, 2024, 4:11:13 PM
    Author     : marlon
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Publicaciones</title>
    <link rel="stylesheet" href="./styles/verPublicaciones.css"/>
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
              <img src="${pageContext.request.contextPath}/avatares/${imagenAvatar}" alt="Perfil"/>
              <span>${usuario}</span>
          </div>
      </header>
      
      
        <!-- Lista de posts anclados -->
            <div class="pinned-posts">
                <c:forEach var="publicacionAnclada" items="${publicacionesFijadas}">
                    <div class="post-item">
                        <i class="fas fa-thumbtack pinned-icon"></i> <!-- Icono de pin -->
                        <img  class="foto-post"  src = "${pageContext.request.contextPath}/portadas/${publicacionAnclada.portada}" alt="Dinosaurios Voladores">
                        <div class="post-content">
                           <a href="VerPublicacionAnclada?id=${publicacionAnclada.id}"><h3>${publicacionAnclada.titulo}</h3></a>
                            <p class="contenido-publicacion">${publicacionAnclada.contenido}</p>
                            <span class="date">${publicacionAnclada.fechaHoraCreacion}</span>
                        </div>
                        <div class="post-info">
                            <div class="usuario">
                                <span>${publicacionAnclada.usuario.nombreUsuario}</span>
                                <img class="foto-perfil" src="${pageContext.request.contextPath}/avatares/${publicacionAnclada.usuario.avatar}" alt="Usuario #4">
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
                    <img class="foto-post" src="${pageContext.request.contextPath}/portadas/${publicacion.portada}"  alt="Tipos de Dinosaurios">
                <div class="post-content">
                    <a href="VerPublicacion?id=${publicacion.id}"><h3>${publicacion.titulo}</h3></a>
                    <p class="contenido-publicacion">${publicacion.contenido}</p>
                    <span class="date">${publicacion.fechaHoraCreacion}</span>
                </div>
                <div class="post-info">
                  <div class="usuario"> 
                    <span>${publicacion.usuario.nombreUsuario}</span>
                    <img class="foto-perfil" src="${pageContext.request.contextPath}/avatares/${publicacion.usuario.avatar}" alt="Tipos de Dinosaurios">
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
            <span>1</span>
            <i class="fas fa-chevron-right"></i>
        </div>
    </div>
</body>
</html>

