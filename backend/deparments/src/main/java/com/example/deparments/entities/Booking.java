package com.example.deparments.entities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reserva")
public class Booking {

    @Id
    @SequenceGenerator(name = "reserva_sequence",
            sequenceName = "reserva_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "reserva_sequence")
    private Long id;

    @Column(name="hora_inicial")
    private Date horaInicial;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="fecha_inicial")
    private Date fechaInicial;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="fecha_final")
    private Date fechaFinal;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;


    public Booking(Long id,
                   Date horaInicial,
                   Date fechaInicial,
                   Date fechaFinal,
                   Product producto,
                   User usuario) {
        this.id = id;
        this.horaInicial = horaInicial;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Booking(Date horaInicial,
                   Date fechaInicial,
                   Date fechaFinal,
                   Product producto,
                   User usuario) {
        this.horaInicial = horaInicial;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Booking() {  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public User getCliente() { return usuario;
    }

    public void setCliente(User usuario) {
        this.usuario = usuario;
    }

}
