package com.example.deparments.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Category {

    @Id
    @SequenceGenerator(name = "categoria_sequence",
            sequenceName = "categoria_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "categoria_sequence")
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String urlimagen;

    public Category(Long id,
                    String titulo,
                    String descripcion,
                    String urlimagen,
                    List<Product> productos) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
    }

    public Category(String titulo,
                    String descripcion,
                    String urlimagen,
                    List<Product> productos) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
    }

    public Category() { }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getURLImagen() {
        return urlimagen;
    }

    public void setURLImagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
