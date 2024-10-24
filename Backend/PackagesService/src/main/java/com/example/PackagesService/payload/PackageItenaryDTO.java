package com.example.PackagesService.payload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PackageItenaryDTO {
    private Long itenaryId;
    private Long packageID;
    @NotEmpty(message = "Day must not be empty.")
    private String day;
    @NotEmpty(message = "Title must not be empty.")
    private String title;
    @NotEmpty(message = "Activities must not be empty.")
    private String activities;
    @NotEmpty(message = "Itenary Image must not be empty.")
    private String itenaryImage;
}
