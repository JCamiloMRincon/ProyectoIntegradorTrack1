package com.example.deparments.repositories;

import com.example.deparments.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM reserva WHERE producto_id =:productId",
            nativeQuery = true)
    List<Booking> findBookingsByProductId(@Param("productId")Long productId);

    @Query(value = "SELECT * FROM reserva WHERE usuario_id =:userId",
            nativeQuery = true)
    List<Booking> findBookingsByUserId(@Param("userId")Long userId);

}
