package com.example.deparments.dto;

import java.io.Serializable;
import java.util.Date;

public class BookingPostDto implements Serializable {

    private Long id;
    private Date horaInicial;
    private Date fechaInicial;
    private Date fechaFinal;
    private Long productoId;
    private Long usuarioId;

    public BookingPostDto(Long id,
                         Date horaInicial,
                         Date fechaInicial,
                         Date fechaFinal,
                         Long productoId,
                         Long usuarioId) {
        this.id = id;
        this.horaInicial = horaInicial;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    public BookingPostDto(Date horaInicial,
                         Date fechaInicial,
                         Date fechaFinal,
                         Long productoId,
                         Long usuarioId) {
        this.horaInicial = horaInicial;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    public BookingPostDto() {  }

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

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
