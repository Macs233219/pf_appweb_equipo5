<%-- 
    Document   : verPublicacion
    Created on : Nov 18, 2024, 5:23:11 PM
    Author     : marlon
--%>

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
      <a href="inicio.html"><img src="imgs/logo-dinosaurio.png" alt="Logo personalizado"></a>
    </div>
    <div class="search-bar">
    </div>
    <div class="profile">
      <img src="imgs/avatar_1.png" alt="Perfil">
      <span>Perfil</span>
    </div>
  </header>


  <div class="contenedor">
    <div class="perfil-publicacion">
      <img src="imgs/avatar_1.png" alt="Perfil de usuario" height="40" width="40" />
      <h3>Usuario #1</h3>
    </div>
    <div class="encabezado-publicacion">
      <h3>Tipos de Dinosaurios</h3>
      <h3>12 de septiembre de 2024</h3>
    </div>

    <p>
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio ea quasi
      voluptas iusto consectetur deleniti odio esse quam eius, quis
      exercitationem ipsam voluptates quia sint in dolorem nam quidem
      repellat?Lorem ipsum dolor sit amet consectetur adipisicing elit. Id
      expedita placeat qui quis eius, dicta in aperiam ipsam voluptas ratione,
      provident at distinctio tenetur. Totam temporibus beatae non!
      Voluptatum, odio.
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
    <div>
      <div class="perfil-publicacion">
        <img src="imgs/avatar_2.png" alt="Perfil de usuario" width="40" height="40" />
        <h3>Usuario #2</h3>
      </div>
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Maiores aut
        dolorem, excepturi commodi quam voluptate officia voluptatum iusto
        autem mollitia corrupti, tempore dicta, ad placeat est deserunt ea
        dolores blanditiis!
      </p>
    </div>

    <hr>

    <div>
      <div class="perfil-publicacion">
        <img src="imgs/avatar_3.png" alt="Perfil de usuario" width="40" height="40" />
        <h3>Usuario #3</h3>
      </div>
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Maiores aut
        dolorem, excepturi commodi quam voluptate officia voluptatum iusto
        autem mollitia corrupti, tempore dicta, ad placeat est deserunt ea
        dolores blanditiis!
      </p>
    </div>
  </div>
</body>

</html>
