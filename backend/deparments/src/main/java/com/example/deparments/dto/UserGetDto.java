package com.example.deparments.dto;

import java.io.Serializable;

public class UserGetDto implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    public UserGetDto(Long id,
                      String nombre,
                      String apellido,
                      String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UserGetDto(String nombre,
                      String apellido,
                      String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UserGetDto() {  }

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

}
