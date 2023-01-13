package com.example.deparments.repositories;

import com.example.deparments.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IFeatureRepository extends JpaRepository<Feature, Long>{
    Optional<Feature> findByNombre(String nombre);
}
