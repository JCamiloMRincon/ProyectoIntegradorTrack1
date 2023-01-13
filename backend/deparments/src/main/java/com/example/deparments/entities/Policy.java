package com.example.deparments.entities;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "politica")
public class Policy {

    @Id
    @SequenceGenerator(name = "politica_sequence",
            sequenceName = "politica_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "politica_sequence")
    private Long id;
    @Column
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "tipo_politica_id")
    private PolicyType tipo;

    public Policy(Long id,
                  String nombre,
                  PolicyType tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Policy(String nombre,
                  PolicyType tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Policy() {  }

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

    public PolicyType getTipo() {
        return tipo;
    }

    public void setTipo(PolicyType tipo) {
        this.tipo = tipo;
    }

}
