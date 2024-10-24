package com.example.BookingsService.payload;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookingDTO {
    @NotNull(message = "UserId must not be empty.")
    private long userID;
    private long bookingID;
    @NotNull(message = "PackageId must not be empty.")
    private long packageID;
    @NotEmpty(message = "Booking date must not be empty and must be in format (YYYY-MM-DD)")
    private String bookingDate;
    @NotEmpty(message = "Travel date must not be empty and must be in format (YYYY-MM-DD)")
    private String travelDate;
    @NotNull(message = "No. of Persons must not be empty and should greater than 0.")
    @Positive
    private Long noOfPersons;
    @NotNull(message = "Total Amount must not be empty.")
    private Double totalAmount;
}
