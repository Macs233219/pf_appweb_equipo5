<%-- 
    Document   : verPublicacion
    Created on : Nov 18, 2024, 5:23:11 PM
    Author     : marlon
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Publicación</title>
        <link rel="stylesheet" href="./styles/publicacion.css"/>
    </head>

    <body>

        <div class="container">
            <!-- Encabezado -->
            <header class="barra-navegacion">
                <div class="custom-logo2">
                    <a href="${pageContext.request.contextPath}/VolverPublicaciones"><img src="imgs/logo-dinosaurio.png" alt="Logo personalizado"></a>
                </div>
                <div class="search-bar">
                </div>
                <div class="profile">
                    <img class="foto-perfil" src="${pageContext.request.contextPath}/avatares/${imagenAvatar}" alt="Perfil">
                    <span>${usuario}</span>
                </div>
            </header>


            <div class="contenedor">
                <div class="perfil-publicacion">
                    <img class="foto-perfil" src="${pageContext.request.contextPath}/avatares/${publicacion.usuario.avatar}" alt="Perfil de usuario"/>
                    <h3>${publicacion.usuario.nombreUsuario}</h3>
                </div>
                <div class="encabezado-publicacion">
                    <h3>${publicacion.titulo}</h3>
                    <h3>${publicacion.fechaHoraCreacion}</h3>
                </div>

                <p>
                    ${publicacion.contenido}
                </p>
            </div>

            <div class="contenedor">
                <div class="perfil-publicacion">
                    <img class="foto-perfil" src="${pageContext.request.contextPath}/avatares/${imagenAvatar}" alt="Perfil de usuario"/>
                    <h3>${usuario}</h3>
                </div>
                <form id="informacion-responder" method="POST">
                    <input type="hidden" name="publicacionAComentarID"  id="publicacionAComentarID" value="${publicacion.id}">
                    <textarea name="comentario-nuevo" id="comentario-nuevo" placeholder="Escribir respuesta..." cols="175" rows="4"
                              required></textarea>
                    <div>
                        <input class="boton" type="submit" id="comentar" value="RESPONDER">
                    </div>
                </form>
            </div>

            <div class="contenedor">
                <c:forEach var="comentario" items="${publicacion.comentarios}">
                    <div>
                        <div class="perfil-publicacion">
                            <img class="foto-perfil" src="${pageContext.request.contextPath}/avatares/${comentario.usuario.avatar}" alt="Perfil de usuario"/>
                            <h3>${comentario.usuario.nombreUsuario}</h3>
                        </div>
                        <p>
                            ${comentario.contenido}
                        </p>
                    </div>
                    <hr>
                </c:forEach>
            </div>
        </div>
        <script src="./scripts/crearComentarioScript.js"></script>
    </body>

</html>
