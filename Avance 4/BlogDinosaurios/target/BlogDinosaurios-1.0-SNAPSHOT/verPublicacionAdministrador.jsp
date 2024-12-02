<%-- 
    Document   : verPublicacionAdministrador
    Created on : 1 dic. 2024, 17:20:46
    Author     : Jose Pablo
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
                    <a href="${pageContext.request.contextPath}/VolverPublicacionesAdministrador"><img src="imgs/logo-dinosaurio.png" alt="Logo personalizado"></a>
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
                <form action="">
                    <textarea name="comentario" id="comentario" placeholder="Escribir respuesta..." cols="175" rows="4"
                              required></textarea>
                    <div>
                        <button class="boton">RESPONDER</button>
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

    </body>

</html>
