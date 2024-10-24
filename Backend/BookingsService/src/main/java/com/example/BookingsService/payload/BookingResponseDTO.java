package com.example.BookingsService.payload;

public class BookingResponseDTO {
    private final String message;

    public BookingResponseDTO(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
