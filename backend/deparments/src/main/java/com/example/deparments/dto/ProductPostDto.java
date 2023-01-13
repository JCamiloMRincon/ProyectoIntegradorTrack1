package com.example.deparments.dto;

import java.io.Serializable;
import java.util.Set;

public class ProductPostDto implements Serializable {

    private Long id;
    private String titulo;
    private Long categoriaId;
    private String direccion;
    private Long ciudadId;
    private String descripcion;
    private boolean disponible;
    private Set<ImagePostDto> imagenes;
    private Set<FeaturePostDto> caracteristicas;
    private Set<PolicyPostDto> politicas;

    public ProductPostDto(Long id,
                          String titulo,
                          Long categoriaId,
                          String direccion,
                          Long ciudadId,
                          String descripcion,
                          boolean disponible,
                          Set<ImagePostDto> imagenes,
                          Set<FeaturePostDto> caracteristicas,
                          Set<PolicyPostDto> politicas) {
        this.id = id;
        this.titulo = titulo;
        this.categoriaId = categoriaId;
        this.direccion = direccion;
        this.ciudadId = ciudadId;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.politicas = politicas;
    }

    public ProductPostDto(String titulo,
                          Long categoriaId,
                          String direccion,
                          Long ciudadId,
                          String descripcion,
                          boolean disponible,
                          Set<ImagePostDto> imagenes,
                          Set<FeaturePostDto> caracteristicas,
                          Set<PolicyPostDto> politicas) {
        this.titulo = titulo;
        this.categoriaId = categoriaId;
        this.direccion = direccion;
        this.ciudadId = ciudadId;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.politicas = politicas;
    }

    public ProductPostDto() {  }

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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Set<ImagePostDto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Set<ImagePostDto> imagenes) {
        this.imagenes = imagenes;
    }

    public Set<FeaturePostDto> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<FeaturePostDto> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Set<PolicyPostDto> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(Set<PolicyPostDto> politicas) {
        this.politicas = politicas;
    }
}
