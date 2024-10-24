package com.example.BookingsService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;

    @Column(name = "userID")
    private Long userID;

    @Column(name = "packageID")
    private Long packageID;

    @Column(name ="bookingDate")
    private String bookingDate;

    @Column(name = "travelDate")
    private String travelDate;

    @Column(name= "noOfPersons")
    private Long noOfPersons;

    @Column(name = "totalAmount")
    private Double totalAmount;

}

