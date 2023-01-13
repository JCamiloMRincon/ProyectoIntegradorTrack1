package com.example.deparments.repositories;

import com.example.deparments.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findByTitulo(String titulo);
    @Query(value = "SELECT * FROM producto WHERE ciudad_id=:cityId", nativeQuery = true)
    List<Product> findByCityId(@Param("cityId")Long cityId);
    @Query(value = "SELECT * FROM producto WHERE categoria_id=:categoryId", nativeQuery = true)
    List<Product> findByCategoryId(@Param("categoryId")Long categoryId);
    @Query(value="SELECT p.* FROM producto p INNER JOIN reserva r ON p.id = r.producto_id WHERE \n" +
            "(?1 < r.fecha_inicial AND ?2 < r.fecha_inicial) OR \n" +
            "(?1 > r.fecha_final AND ?2 > r.fecha_final);", nativeQuery = true)
    List<Product> findBetweenTwoDates(Date firstDate, Date lastDate);
    @Query(value="SELECT MAX(id) FROM producto", nativeQuery = true)
    Long getLastId();
}
