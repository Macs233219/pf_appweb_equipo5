/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipoUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String correo;
    private String contrasenia;
    private String telefono;
    private String avatar;
    private String ciudad;
    private Date fechaNacimiento;
    private String genero;

    // Relaciones con Municipio y otras entidades
    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;

    // Getters y setters
}

