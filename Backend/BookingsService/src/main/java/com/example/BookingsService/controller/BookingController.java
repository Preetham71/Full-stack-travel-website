package com.example.BookingsService.controller;

import com.example.BookingsService.payload.BookingDTO;
import com.example.BookingsService.payload.BookingResponseDTO;
import com.example.BookingsService.service.impl.BookingServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
    private final BookingServiceImpl bookingService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity<>(bookingService.createBooking(bookingDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public BookingDTO getBookingDetailsById(@PathVariable long id) {
        return bookingService.getBookingDetailsById(id);
    }


    @PutMapping("/{id}")
    public BookingDTO updateUserBooking(@PathVariable long id,@RequestBody BookingDTO bookingDTO) {
        return bookingService.updateUserBooking( id, bookingDTO);
    }

    @DeleteMapping("/{id}")
    public BookingResponseDTO deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
        BookingResponseDTO bookingResponseDtoDTO = new BookingResponseDTO("Booking deleted successfully!");
        return bookingResponseDtoDTO;
    }
}
