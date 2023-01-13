package com.example.deparments.dto;

import java.io.Serializable;

public class UserPostDto implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private Long ciudadId;
    private Long rolId;

    public UserPostDto(Long id,
                       String nombre,
                       String apellido,
                       String email,
                       String contrasenia,
                       Long rolId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rolId = rolId;
    }

    public UserPostDto(String nombre,
                       String apellido,
                       String email,
                       String contrasenia,
                       Long rolId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rolId = rolId;
    }

    public UserPostDto(String nombre,
                       String apellido,
                       String email,
                       String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public UserPostDto() {  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }
}
