package com.example.deparments.repositories;

import com.example.deparments.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Long> {
    Optional<Policy> findByNombre(String nombre);
}
