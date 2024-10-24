package com.example.PackagesService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="packageItenary")
public class PackageItenary {
    @Id
    @Column(name="itenaryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itenaryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="packageID", nullable = false)
    @JsonIgnore
    private Package aPackage;

    @Column(name="day")
    private String day;

    @Column(name="title")
    private String title;

    @Column(name="activities")
    private String activities;

    @Column(name="itenaryImage")
    private String itenaryImage;

}
