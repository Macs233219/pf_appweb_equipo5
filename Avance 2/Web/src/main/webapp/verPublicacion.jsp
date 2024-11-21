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


  <!-- Encabezado -->
  <header class="barra-navegacion">
    <div class="custom-logo2">
      <a href="VolverPublicaciones"><img src="imgs/logo-dinosaurio.png" alt="Logo personalizado"></a>
    </div>
    <div class="search-bar">
    </div>
    <div class="profile">
      <img src="imgs/avatar_1.png" alt="Perfil">
      <span>${usuario}</span>
    </div>
  </header>


  <div class="contenedor">
    <div class="perfil-publicacion">
      <img src="imgs/avatar_1.png" alt="Perfil de usuario" height="40" width="40" />
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

  <div class="contenedor">
    <div class="perfil-publicacion">
      <img src="imgs/avatar_0.png" alt="Perfil de usuario" width="40" height="40" />
      <h3>Usuario</h3>
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
              <img src="imgs/avatar_2.png" alt="Perfil de usuario" width="40" height="40" />
              <h3>${comentario.usuario.nombreUsuario}</h3>
            </div>
            <p>
              ${comentario.contenido}
            </p>
          </div>

          <hr>
      </c:forEach>

  </div>
</body>

</html>
