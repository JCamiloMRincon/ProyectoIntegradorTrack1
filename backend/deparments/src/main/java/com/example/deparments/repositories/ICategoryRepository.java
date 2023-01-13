package com.example.deparments.repositories;

import com.example.deparments.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByTitulo(String titulo);
}
