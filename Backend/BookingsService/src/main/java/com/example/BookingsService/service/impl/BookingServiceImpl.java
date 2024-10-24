package com.example.BookingsService.service.impl;

import com.example.BookingsService.Exception.ResourceNotFoundException;
import com.example.BookingsService.entity.Booking;
import com.example.BookingsService.payload.BookingDTO;
import com.example.BookingsService.repository.BookingRepositry;
import com.example.BookingsService.service.BookingService;
import com.example.BookingsService.util.MapperLibrary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepositry bookingRepositry;
    private final MapperLibrary mapperLibrary;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingRepositry.save(mapperLibrary.mapToBooking(bookingDTO));
        return mapperLibrary.mapToBookingDTO(booking);
    }

    @Override
    public BookingDTO getBookingDetailsById(long id) {
        Booking booking = bookingRepositry.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Booking", "id", id)
        );
        return mapperLibrary.mapToBookingDTO(booking);
    }

    @Override
    public BookingDTO updateUserBooking(long id,BookingDTO bookingDTO) {
        Booking existingBooking = bookingRepositry.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bookings", "id", id)
        );
        existingBooking.setUserID(bookingDTO.getUserID());
        existingBooking.setPackageID(bookingDTO.getPackageID());
        existingBooking.setBookingDate(bookingDTO.getBookingDate());
        existingBooking.setTravelDate(bookingDTO.getTravelDate());
        existingBooking.setNoOfPersons(bookingDTO.getNoOfPersons());
        existingBooking.setTotalAmount(bookingDTO.getTotalAmount());
        return  mapperLibrary.mapToBookingDTO(bookingRepositry.save(existingBooking));
    }

    @Override
    public void deleteBooking(Long bookingID) {
        Booking booking = bookingRepositry.findById(bookingID).orElseThrow(
                () -> new ResourceNotFoundException("Booking not found for this id :: " + bookingID)
        );
        bookingRepositry.delete(booking);
    }


}
