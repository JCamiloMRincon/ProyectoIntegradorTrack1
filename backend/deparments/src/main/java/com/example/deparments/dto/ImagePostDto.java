package com.example.deparments.dto;

import java.io.Serializable;

public class ImagePostDto implements Serializable {

    private Long id;
    private Long productoId;
    private String titulo;
    private String url;

    public ImagePostDto(Long id, Long productoId, String titulo, String url) {
        this.id = id;
        this.productoId = productoId;
        this.titulo = titulo;
        this.url = url;
    }

    public ImagePostDto(Long productoId, String titulo, String url) {
        this.productoId = productoId;
        this.titulo = titulo;
        this.url = url;
    }

    public ImagePostDto(String url) {
        this.url = url;
    }

    public ImagePostDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
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
