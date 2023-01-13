package com.example.deparments.services;

import com.example.deparments.dto.BookingGetDto;
import com.example.deparments.dto.BookingPostDto;
import com.example.deparments.entities.Booking;
import com.example.deparments.entities.Product;
import com.example.deparments.entities.User;
import com.example.deparments.repositories.IBookingRepository;
import com.example.deparments.repositories.IProductRepository;
import com.example.deparments.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImp implements IBookingService {

    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByProductId(Long productId) {
        return bookingRepository.findBookingsByProductId(productId);
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findBookingsByUserId(userId);
    }

    @Override
    public Booking saveBooking(BookingPostDto bookingPostDto) {
        Booking booking = convertBookingDtoToBooking(bookingPostDto);
        return bookingRepository.save(booking);
    }

    public Booking convertBookingDtoToBooking(BookingPostDto bookingDto) {

        Booking booking = new Booking();
        Product product = productRepository.findById(bookingDto.getProductoId()).get();
        User user = userRepository.findById(bookingDto.getUsuarioId()).get();

        booking.setHoraInicial( bookingDto.getHoraInicial() );
        booking.setFechaInicial( bookingDto.getFechaInicial() );
        booking.setFechaFinal( bookingDto.getFechaFinal() );
        booking.setProducto( product );
        booking.setCliente( user );

        return booking;
    }

    public BookingGetDto convertBookingToBookingDto(Booking booking) {

        BookingGetDto bookingDto = new BookingGetDto();

        bookingDto.setId( booking.getId() );
        bookingDto.setHoraInicial( booking.getHoraInicial() );
        bookingDto.setFechaInicial( booking.getFechaInicial() );
        bookingDto.setFechaFinal( booking.getFechaFinal() );
        bookingDto.setProductoId( booking.getProducto().getId() );
        bookingDto.setUsuarioId( booking.getCliente().getId() );

        return bookingDto;
    }

    public List<BookingGetDto> convertBookingsToBookingsDto(List<Booking> bookings) {

        List<BookingGetDto> bookingsDto = new ArrayList<>();

        for(int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            BookingGetDto bookingDto = new BookingGetDto();

            bookingDto.setId( booking.getId() );
            bookingDto.setHoraInicial( booking.getHoraInicial() );
            bookingDto.setFechaInicial( booking.getFechaInicial() );
            bookingDto.setFechaFinal( booking.getFechaFinal() );
            bookingDto.setProductoId( booking.getProducto().getId() );
            bookingDto.setUsuarioId( booking.getCliente().getId() );

            bookingsDto.add( bookingDto );
        }

        return bookingsDto;
    }
}
