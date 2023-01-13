package com.example.deparments.repositories;

import com.example.deparments.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
