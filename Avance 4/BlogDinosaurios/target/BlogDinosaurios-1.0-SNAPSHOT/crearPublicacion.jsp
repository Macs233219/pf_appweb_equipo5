<%-- 
    Document   : crearPublicacion
    Created on : 1 dic. 2024, 19:08:50
    Author     : Jose Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./styles/crearPublicacion.css">
        <title>Crear Publicación</title>
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

            <div class="cuerpo">
                <h1>Crear una nueva publicación</h1>

                <div class="linea"></div>

                <form id="informacionPublicacion" method="POST" enctype="multipart/form-data">
                    <div class="contenedor-titulo-etiqueta">
                        <label for="titulo">Título</label>
                        <div>
                            <input class="input-titulo-etiqueta" type="text" name="titulo"
                                   id="titulo" placeholder="Título de la publicación" required>
                        </div>
                    </div>

                    <div>
                        <label for="contenido">Contenido</label>
                        <div>
                            <textarea name="contenido" id="contenido" placeholder="Escribe el contenido de tu publicacion" required></textarea>
                        </div>
                    </div>

                    <div class="contenedor-file">
                        <label for="archivos">Portada</label>
                        <input type="file" name="imagen-portada" id="portada" required>
                    </div>
                    <div class="linea"></div>
                    <div>
                        <input class="boton verde-oscuro" type="submit" id="enviar" value="PUBLICAR">
                        <input class="boton verde-claro" type="button" value="VISTA PREVIA">
                    </div>
                </form>
            </div>
        </div>
        <script src="./scripts/crearPublicacionScript.js"></script>
    </body>

</html>