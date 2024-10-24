package com.example.BookingsService.util;

import com.example.BookingsService.BookingsServiceApplication;
import com.example.BookingsService.entity.Booking;
import com.example.BookingsService.payload.BookingDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperLibrary {

    public Booking mapToBooking(BookingDTO bookingDTO){
        return BookingsServiceApplication.modelMapper().map(bookingDTO,Booking.class);
    }
    public BookingDTO mapToBookingDTO(Booking booking){
        return BookingsServiceApplication.modelMapper().map(booking,BookingDTO.class);
    }
}
