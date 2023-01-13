package com.example.deparments.repositories;

import com.example.deparments.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long>{
    Optional<Country> findByNombre(String nombre);
}
