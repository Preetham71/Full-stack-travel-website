package com.example.BookingsService.repository;

import com.example.BookingsService.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepositry extends JpaRepository<Booking,Long> {

}
