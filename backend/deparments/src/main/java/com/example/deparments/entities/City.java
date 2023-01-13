package com.example.deparments.entities;
import javax.persistence.*;

@Entity
@Table(name = "ciudad")
public class City {

    @Id
    @SequenceGenerator(name = "ciudad_sequence",
            sequenceName = "ciudad_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ciudad_sequence")
    private Long id;
    @Column
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Country pais;

    public City(Long id,
                String nombre,
                Country pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public City(String nombre,
                Country pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public City() { }

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

    public Country getPais() {
        return pais;
    }

    public void setPais(Country pais) {
        this.pais = pais;
    }
}
