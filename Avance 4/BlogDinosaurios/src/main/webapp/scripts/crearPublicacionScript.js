/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const form = document.querySelector("#informacionPublicacion");

async function enviarDatos() {
    const formData = new FormData(form);

    const datos = {
        fechaHoraCreacion: null,
        titulo: formData.get("titulo"),
        contenido: formData.get("contenido"),
        fechaHoraEdicion: null,
        portada: formData.get("imagen-portada").name,
        comentarios: null
    };
    
    //Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion, String portada

    console.log(datos);

    try {
        const response = await fetch("http://localhost:8080/BlogDinosaurios/CrearPublicacion", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(datos)
        });

        const result = await response.json();
        console.log(result);
       
        if (result.status === "success") {
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

// D:\clases\10\Apps web\Proyecto-Dinosaurios---Equipo-5\Avance 4\BlogDinosaurios\src\main\java\controlador\CrearPublicacion.java
