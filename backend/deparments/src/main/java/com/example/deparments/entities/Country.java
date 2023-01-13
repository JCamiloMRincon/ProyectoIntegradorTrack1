package com.example.deparments.entities;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "pais")
public class Country {

    @Id
    @SequenceGenerator(name = "pais_sequence",
            sequenceName = "pais_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pais_sequence")
    private Long id;
    @Column
    private String nombre;

    public Country(Long id,
                   String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Country(String nombre) {
        this.nombre = nombre;
    }

    public Country() {  }

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

}
