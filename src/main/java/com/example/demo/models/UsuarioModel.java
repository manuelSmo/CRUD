package com.example.demo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @Column(unique = true, nullable = false)
    private Long cedulaUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String numeroTelefonoUsuario;
    private String emailUsuario;
    private Integer edadUsuario;

}
