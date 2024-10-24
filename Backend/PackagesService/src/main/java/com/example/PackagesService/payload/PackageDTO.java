package com.example.PackagesService.payload;

import com.example.PackagesService.entity.PackageItenary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDTO {
    private Long packageID;
    @NotEmpty(message = "Country must not be empty.")
    private String packageCountry;
    @NotEmpty(message = "City must not be empty.")
    private String packageCity;
    @NotEmpty(message = "Name must not be empty.")
    private String packageName;
    @NotEmpty(message = "Description must not be empty.")
    private String packageDesc;
    @NotNull(message = "Rating must not be empty.")
    private Long packageRating;
    @NotNull(message = "Reviews must not be empty.")
    private Long packageReviews;
    @NotNull(message = "Price must not be empty.")
    private double packagePrice;
    @NotEmpty(message = "Package Duration must not be empty.")
    private  String packageDuration;
    @Positive
    @NotNull(message = "Min Age must not be empty.")
    private Long minAge;
    @Positive
    @NotNull(message = "Max People must not be empty.")
    private String maxPeople;
    @NotNull(message = "Available Date must not be empty.")
    private String availableDate;
    @NotNull(message = "Language must not be empty.")
    private String packageLanguage;
    @NotNull(message = "Image must not be empty.")
    private String packageImage;
    List<PackageItenary> packageItenaryList = new ArrayList<>();
}
