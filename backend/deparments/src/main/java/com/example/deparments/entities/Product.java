package com.example.deparments.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "producto")
public class Product {

    @Id
    @SequenceGenerator(name = "producto_sequence",
            sequenceName = "producto_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "producto_sequence")
    private Long id;
    @Column
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category categoria;
    @Column
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private City ciudad;
    @Column
    private String descripcion;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "producto_caracteristica",
            joinColumns = { @JoinColumn(name = "producto_id") },
            inverseJoinColumns = { @JoinColumn(name = "caracteristica_id") }
    )
    private Set<Feature> caracteristicas;
    @Column(columnDefinition = "TINYINT", length = 1)
    private boolean disponible;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "producto_politica",
            joinColumns = { @JoinColumn(name = "producto_id") },
            inverseJoinColumns = { @JoinColumn(name = "politica_id")}
    )
    private Set<Policy> politicas;

    public Product(Long id,
                   String titulo,
                   Category categoria,
                   String direccion,
                   City ciudad,
                   String descripcion,
                   Set<Feature> caracteristicas,
                   boolean disponible,
                   Set<Policy> politicas) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.disponible = disponible;
        this.politicas = politicas;
    }

    public Product(String titulo,
                   Category categoria,
                   String direccion,
                   City ciudad,
                   String descripcion,
                   Set<Feature> caracteristicas,
                   boolean disponible,
                   Set<Policy> politicas) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.disponible = disponible;
        this.politicas = politicas;
    }

    public Product() {  }

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
}
