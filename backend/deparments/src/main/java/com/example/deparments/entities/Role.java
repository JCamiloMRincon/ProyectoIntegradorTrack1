package com.example.deparments.entities;

import javax.persistence.*;

@Entity
@Table(name="rol")
public class Role {

    @Id
    @SequenceGenerator(name = "rol_sequence",
            sequenceName = "rol_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "rol_sequence")
    private Long id;
    @Column
    private String nombre;

    public Role(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Role(String nombre) {
        this.nombre = nombre;
    }

    public Role() {  }

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
