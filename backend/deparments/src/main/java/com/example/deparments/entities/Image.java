package com.example.deparments.entities;

import javax.persistence.*;

@Entity
@Table(name = "imagen")
public class Image {

    @Id
    @SequenceGenerator(name = "imagen_sequence",
            sequenceName = "imagen_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "imagen_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product producto;
    @Column
    private String titulo;
    @Column
    private String url;

    public Image(Long id,
                 Product producto,
                 String titulo,
                 String url) {
        this.id = id;
        this.producto = producto;
        this.titulo = titulo;
        this.url = url;
    }

    public Image(Product producto,
                 String titulo,
                 String url) {
        this.producto = producto;
        this.titulo = titulo;
        this.url = url;
    }

    public Image() {  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
