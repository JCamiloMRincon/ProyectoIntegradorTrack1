package com.example.deparments.repositories;

import com.example.deparments.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City, Long>{
    Optional<City> findByNombre(String nombre);
}
