package com.example.deparments.dto;

import java.io.Serializable;

public class PolicyPostDto implements Serializable {

    private Long id;
    private String nombre;
    private Long tipoPoliticaId;

    public PolicyPostDto(Long id, String nombre, Long tipoPoliticaId) {
        this.id = id;
        this.nombre = nombre;
        this.tipoPoliticaId = tipoPoliticaId;
    }

    public PolicyPostDto(Long id) {
        this.id = id;
    }

    public PolicyPostDto(String nombre, Long tipoPoliticaId) {
        this.nombre = nombre;
        this.tipoPoliticaId = tipoPoliticaId;
    }

    public PolicyPostDto() {  }

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

    public Long getTipoPoliticaId() {
        return tipoPoliticaId;
    }

    public void setTipoPoliticaId(Long tipoPoliticaId) {
        this.tipoPoliticaId = tipoPoliticaId;
    }
}
