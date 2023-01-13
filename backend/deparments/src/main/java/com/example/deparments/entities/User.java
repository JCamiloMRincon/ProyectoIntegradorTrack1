package com.example.deparments.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class User {

    @Id
    @SequenceGenerator(name = "usuario_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "usuario_sequence")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @Column
    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private City ciudad;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Role rol;

    public User(Long id,
                String nombre,
                String apellido,
                String email,
                String contrasenia,
                City ciudad,
                Role rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.ciudad = ciudad;
        this.rol = rol;
    }

    public User(String nombre,
                String apellido,
                String email,
                String contrasenia,
                City ciudad,
                Role rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.ciudad = ciudad;
        this.rol = rol;
    }

    public User() {  }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public City getCiudad() {
        return ciudad;
    }

    public void setCiudad(City ciudad) {
        this.ciudad = ciudad;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

}
