package com.example.deparments.repositories;

import com.example.deparments.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM usuario WHERE email=:email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email")String email);
}
