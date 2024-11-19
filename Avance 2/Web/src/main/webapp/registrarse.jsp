<%-- 
    Document   : registrarse
    Created on : Nov 18, 2024, 7:03:04 PM
    Author     : marlon
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./styles/registrarse.css"/>
        <title>Registrarse</title>
    </head>

    <body>
        <div class="registrarse">
            <a href="index.jsp"><img class="img-titulo" src="./imgs/logo-dinosaurio.png" alt="Logo de Dinosaurio"></a>
            <h1>REGISTRARSE</h1>
        </div>
        <form action="iniciarSesion.html">
            <div class="formulario">
                <div columna>
                    <label for="nombres">NOMBRES</label>
                    <div>
                        <input type="text" name="nombres" placeholder="NOMBRES" required>
                    </div>
                    <label for="correo">CORREO</label>
                    <div>
                        <input type="email" name="correo" placeholder="CORREO@DOMINIO.COM" required>
                    </div>
                    <label for="usuario">NOMBRE DE USUARIO</label>
                    <div>

                        <input type="text" name="usuario" placeholder="NOMBRE DE USUARIO" required>
                    </div>
                    <label for="estados">ESTADO</label>
                    <div>
                        <select class="selector" name="estado" id="estado" required>
                            
                            <c:forEach var="estado" items="${estados}">
                                <option value="${estado.nombre}">${estado.nombre}</option>
                            </c:forEach>
                            
                        </select>
                    </div>
                    <label for="municipio">MUNICIPIO</label>
                    <div>
                        <select class="selector" name="municipio" id="municipio" required>
                            
                            <c:forEach var="municipio" items="${municipios}">
                                <option value="${municipio.nombre}">${municipio.nombre}</option>
                            </c:forEach>
                            
                        </select>
                    </div>

                    <label for="genero">GÉNERO</label>
                    <div>
                        <input type="radio" name="genero" value="masculino" checked>
                        <label class="genero" for="masculino">MASCULINO</label>
                        <input type="radio" name="genero" value="femenino">
                        <label class="genero" for="femenino">FEMENINO</label>
                    </div>
                    <label for="fecha">FECHA DE NACIMIENTO</label>
                    <div>
                        <input type="date" required>
                    </div>
                </div>

                <div columna>
                    <label for="apellidos">APELLIDOS</label>
                    <div>
                        <input type="text" name="apellidos" placeholder="APELLIDOS" required>
                    </div>
                    <label for="telefono">TELÉFONO</label>
                    <div>
                        <input type="tel" name="telefono" placeholder="#########" maxlength="10" required>
                    </div>
                    <label for="contrasena">CONTRASEÑA</label>
                    <div>
                        <input type="password" name="contrasena" placeholder="CONTRASEÑA" required>
                    </div>
                    <label for="ciudad">CIUDAD</label>
                    <div>
                        <input type="text" name="ciudad" placeholder="CIUDAD" required>
                    </div>
                    <label for="avatar">AVATAR</label>
                    <div>
                        <img class="avatar" src="./imgs/avatar.png" alt="Imagen de avatar" onclick="document.getElementById('avatarInput').click();">
                    </div>
                    <div>
                        <label class="avatar-boton" for="avatar">SUBIR IMAGEN</label>
                        <input id="avatarInput" class="avatar-input" type="file" name="avatar" style="display:none;"/>
                    </div>
                </div>
            </div>

            <div class="boton-registrarse">
                <img class="img-boton" src="./imgs/boton-dinosaurio.png" alt="Imagen de botón de dinosaurio">
                <input type="submit" value="REGISTRARSE" required>
            </div>
        </form>
    </body>

</html>
