package com.example.deparments.entities;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tipo_politica")
public class PolicyType {

    @Id
    @SequenceGenerator(name = "tipo_politica_sequence",
            sequenceName = "tipo_politica_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tipo_politica_sequence")
    private Long id;
    @Column
    private String descripcion;

    public PolicyType(Long id,
                      String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public PolicyType(String descripcion) {
        this.descripcion = descripcion;
    }

    public PolicyType() {  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
