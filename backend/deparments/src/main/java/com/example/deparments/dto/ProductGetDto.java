package com.example.deparments.dto;

import com.example.deparments.entities.Category;
import com.example.deparments.entities.City;
import com.example.deparments.entities.Feature;
import com.example.deparments.entities.Policy;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class ProductGetDto implements Serializable {

    private Long id;
    private String titulo;
    private Category categoria;
    private String direccion;
    private City ciudad;
    private String descripcion;
    private Set<Feature> caracteristicas;
    private boolean disponible;
    private Set<Policy> politicas;
    private List<ImageGetDto> imagenes;

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

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public City getCiudad() {
        return ciudad;
    }

    public void setCiudad(City ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Feature> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Feature> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Set<Policy> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(Set<Policy> politicas) {
        this.politicas = politicas;
    }

    public List<ImageGetDto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImageGetDto> imagenes) {
        this.imagenes = imagenes;
    }
}
