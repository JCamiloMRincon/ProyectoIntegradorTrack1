package com.example.deparments.services;

import com.example.deparments.dto.BookingPostDto;
import com.example.deparments.entities.Booking;

import java.util.*;

public interface IBookingService {

    List<Booking> getBookings();
    List<Booking> getBookingsByProductId(Long productId);
    List<Booking> getBookingsByUserId(Long userId);
    Booking saveBooking(BookingPostDto bookingPostDto);

}
