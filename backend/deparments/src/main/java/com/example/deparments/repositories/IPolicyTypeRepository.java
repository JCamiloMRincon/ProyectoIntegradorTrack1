package com.example.deparments.repositories;

import com.example.deparments.entities.PolicyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPolicyTypeRepository extends JpaRepository<PolicyType, Long> {
    Optional<PolicyType> findByDescripcion(String descripcion);
}
