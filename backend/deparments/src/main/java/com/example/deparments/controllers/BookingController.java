package com.example.deparments.controllers;

import com.example.deparments.dto.BookingGetDto;
import com.example.deparments.dto.BookingPostDto;
import com.example.deparments.entities.Booking;
import com.example.deparments.services.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/reservas")
public class BookingController {

    @Autowired
    private BookingServiceImp bookingService;

    @GetMapping
    ResponseEntity<List<BookingGetDto>> getAllBookings() {
        List<Booking> bookings = bookingService.getBookings();
        List<BookingGetDto> bookingsDto = bookingService.convertBookingsToBookingsDto(bookings);
        return ResponseEntity.ok( bookingsDto );
    }

    @GetMapping("/producto/{productId}")
    ResponseEntity<List<BookingGetDto>> getBookingsByProductId(@PathVariable("productId") Long productId) {
        List<Booking> bookings = bookingService.getBookingsByProductId(productId);
        List<BookingGetDto> bookingsDto = bookingService.convertBookingsToBookingsDto(bookings);
        return ResponseEntity.ok( bookingsDto );
    }

    @GetMapping("/usuario/{userId}")
    ResponseEntity<List<BookingGetDto>> getBookingsByUserId(@PathVariable("userId") Long userId) {
        List<Booking> bookings = bookingService.getBookingsByUserId(userId);
        List<BookingGetDto> bookingsDto = bookingService.convertBookingsToBookingsDto(bookings);
        return ResponseEntity.ok( bookingsDto );
    }

    @PostMapping
    ResponseEntity<BookingGetDto> saveBooking(@RequestBody BookingPostDto bookingPostDto) {
        Booking booking = bookingService.saveBooking(bookingPostDto);
        BookingGetDto bookingGetDto = bookingService.convertBookingToBookingDto(booking);
        return new ResponseEntity<BookingGetDto>(bookingGetDto, HttpStatus.CREATED);
    }

}
