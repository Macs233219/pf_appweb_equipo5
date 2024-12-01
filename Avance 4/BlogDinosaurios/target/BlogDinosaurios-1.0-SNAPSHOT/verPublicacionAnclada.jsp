<%-- 
    Document   : verPublicacionAnclada
    Created on : 29 nov. 2024, 19:09:18
    Author     : Jose Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicacion</title>
        <link rel="stylesheet" href="./styles/publicacion.css"/>
    </head>
    <body>

        <div class="container">
            <!-- Encabezado -->
            <header class="barra-navegacion">
                <div class="custom-logo2">
                    <a href="VolverPublicaciones"><img src="imgs/logo-dinosaurio.png" alt="Logo personalizado"></a>
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

                <div class="imagen-publicacion">
                    <img src="imgs/imagen_publicacion.jpg" alt="Imagen de publicación" width="500" height="500" />
                </div>
            </div>
        </div>
                
    </body>
</html>
