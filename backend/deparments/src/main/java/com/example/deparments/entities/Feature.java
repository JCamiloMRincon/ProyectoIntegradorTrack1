package com.example.deparments.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "caracteristica")
public class Feature {

    @Id
    @SequenceGenerator(name = "caracteristica_sequence",
            sequenceName = "caracteristica_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "caracteristica_sequence")
    private Long id;
    @Column
    private String nombre;
    @Column
    private String urlicono;

    public Feature(Long id,
                   String nombre,
                   String urlicono) {
        this.id = id;
        this.nombre = nombre;
        this.urlicono = urlicono;
    }

    public Feature(String nombre,
                   String urlicono) {
        this.nombre = nombre;
        this.urlicono = urlicono;
    }

    public Feature() {  }

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
