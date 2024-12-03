/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const form = document.querySelector("#informacion-responder");

async function enviarDatos() {
    const formData = new FormData(form);

    const datos = {
        fechaHora: null,
        contenido: formData.get("comentario-nuevo"),
        postComun: null,
        usuarioNormal: null
    };

    //Date fechaHora, String contenido, PostComun postComun, UsuarioNormal usuarioNormal

    console.log(datos);

    try {
        const response = await fetch("http://localhost:8080/BlogDinosaurios/CrearComentario", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(datos)
        });

        const result = await response.json();
        console.log(result);


        if (result.status === "success") {

//            const idPublicacionActual = document.querySelector('input[name="publicacionActualId"]').value;
//            window.location.href = `http://localhost:8080/BlogDinosaurios/VerPublicacion?id=${idPublicacionActual}`;
            window.location.href = `http://localhost:8080/BlogDinosaurios/VolverPublicaciones`;

        }

    } catch (error) {
        console.log(error);
    }
}

form.addEventListener("submit", (event) => {
    event.preventDefault();
    enviarDatos();
});