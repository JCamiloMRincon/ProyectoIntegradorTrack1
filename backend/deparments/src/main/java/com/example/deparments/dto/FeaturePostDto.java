package com.example.deparments.dto;

import java.io.Serializable;

public class FeaturePostDto implements Serializable {

    private Long id;
    private String nombre;
    private String urlicono;

    public FeaturePostDto(Long id, String nombre, String urlicono) {
        this.id = id;
        this.nombre = nombre;
        this.urlicono = urlicono;
    }

    public FeaturePostDto(Long id) {
        this.id = id;
    }

    public FeaturePostDto(String nombre, String urlicono) {
        this.nombre = nombre;
        this.urlicono = urlicono;
    }

    public FeaturePostDto() {  }

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

    public String getUrlicono() {
        return urlicono;
    }

    public void setUrlicono(String urlicono) {
        this.urlicono = urlicono;
    }
}
