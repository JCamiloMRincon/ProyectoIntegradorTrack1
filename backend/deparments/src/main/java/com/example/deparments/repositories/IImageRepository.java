package com.example.deparments.repositories;

import com.example.deparments.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByTitulo(String titulo);
    @Query(value = "SELECT * FROM imagen WHERE producto_id =:productId",
            nativeQuery = true)
    List<Image> findByProductId(@Param("productId")Long productId);
}
