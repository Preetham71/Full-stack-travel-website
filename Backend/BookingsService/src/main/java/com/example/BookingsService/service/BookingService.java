package com.example.BookingsService.service;

import com.example.BookingsService.payload.BookingDTO;

public interface BookingService {
    BookingDTO createBooking(BookingDTO bookingDTO);
    BookingDTO getBookingDetailsById(long id);
    BookingDTO updateUserBooking(long id,BookingDTO bookingDTO);


    void deleteBooking(Long bookingID);
}
