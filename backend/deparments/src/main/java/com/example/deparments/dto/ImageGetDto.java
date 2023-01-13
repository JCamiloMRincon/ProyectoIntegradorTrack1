package com.example.deparments.dto;

import java.io.Serializable;

public class ImageGetDto implements Serializable {

    private Long id;
    private String titulo;
    private String url;

    public ImageGetDto(Long id, String titulo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
    }

    public ImageGetDto(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public ImageGetDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
