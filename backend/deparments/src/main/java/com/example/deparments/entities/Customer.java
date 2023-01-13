package com.example.deparments.entities;

public class Customer extends User {

    public Customer(Long id,
                    String nombre,
                    String apellido,
                    String email,
                    String contrasenia,
                    City ciudad,
                    Role rol) {
        super(id, nombre, apellido, email, contrasenia, ciudad, rol);
    }

    public Customer(String nombre,
                    String apellido, String email, String contrasenia, City ciudad, Role rol) {
        super(nombre, apellido, email, contrasenia, ciudad, rol);
    }

    public Customer() {  }


}
